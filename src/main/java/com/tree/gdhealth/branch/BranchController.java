package com.tree.gdhealth.branch;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramCalendar;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderAddDto;
import com.tree.gdhealth.sportsequipment.dto.getOrderListResponseDto;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.vo.Employee;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>지점(branch)의 메인 컨트롤러</p>
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/branch")
@Controller
public class BranchController {
    private final BranchService service;
    @GetMapping("/home")
    public String getBranchHome(){
        log.debug("/branch/home");
        return "/branch/home";
    }

    @GetMapping("/testLoginEmployee")
    public String testLogin(HttpSession session){
        Employee employee = new Employee();
        employee.setEmployeeId("gasan1manager");
        employee.setEmployeePw("1234");
        LoginEmployee loginEmployee = service.testEmployeeLogin(employee);
        session.setAttribute("loginEmployee", loginEmployee);
        return "redirect:/branch/home";
    }

    /**
     * @param loginEmployee 로그인된 직원
     * @return 지점의 직원리스트 페이지
     */
    @GetMapping("/employee/list")
    public String getBranchEmployeeList(@SessionAttribute LoginEmployee loginEmployee, Model model){
        model.addAttribute("branchEmployeeList", service.getBranchEmployeeList(loginEmployee.getBranchNo()));
        return "/branch/employee/list";
    }

    /**@return 지점의 물품발주조회 페이지
     * @param requestPage (쿼리스트링)요청 페이지번호
     * @param isOnlyWaitingList (쿼리스트링)대기건만 조회할 것인지 여부
     * @apiNote {@link getOrderListResponseDto} 에 출력정보와 페이지네이션 정보가 함께 들어있습니다.
     */
    @GetMapping("/sportsEquipment/order/list")
    public String getBranchSportsEquipmentOrderList(
            @RequestParam(name = "requestPage", defaultValue = "1") int requestPage,
            @RequestParam(name = "isOnlyWaitingList", defaultValue = "false") boolean isOnlyWaitingList,
            @SessionAttribute("loginEmployee") LoginEmployee loginEmployee,
            Model model) {

        getOrderListResponseDto orderListResponseDto = service.getBranchSportsEquipmentOrderList(
                loginEmployee.getBranchNo(), requestPage, isOnlyWaitingList);

        /*페이지네이션 URI 리스트 생성 시작*/
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        uriComponentsBuilder.path("/branch/sportsEquipment/order/list")
                .queryParam("isOnlyWaitingList", isOnlyWaitingList)
                .queryParam("requestPage", requestPage);
        List<Map<String,Object>> paginationURIList = new ArrayList<>();
        for (int i = -4; i < 5; i++) {
            int page = requestPage + i;
            if ( page >= 1 && page <= orderListResponseDto.getLastPage()) {
                paginationURIList.add(Map.of("page",page, "URI",uriComponentsBuilder.replaceQueryParam("requestPage", page).build()));
            }
        }
        /*페이지네이션 URI 리스트 생성 종료*/
        orderListResponseDto.setPaginationURIList(paginationURIList);

        model.addAttribute("orderListResponseDto", orderListResponseDto);
        return "/branch/sportsEquipment/order/list";
    }

    /**
     * @return 지점물품발주 폼 페이지
     */
    @GetMapping("/sportsEquipment/order/addForm")
    public String getBranchEquipmentOrderAddForm(@SessionAttribute("loginEmployee") LoginEmployee loginEmployee, Model model) {
        SportsEquipmentOrderAddDto dto = new SportsEquipmentOrderAddDto(loginEmployee.getEmployeeNo(), loginEmployee.getBranchNo(), null, null, null);
        model.addAttribute("formDto", dto);
        return "branch/sportsEquipment/order/addForm";
    }

    /**<p>지점물품발주 post</p>
     * @param dto {@link SportsEquipmentOrderAddDto} 필드 유효성검사
     * @return 지점 물품 주문 폼 페이지에 메세지를 쿼리스트링 추가하여 리다이렉트
     */
    @PostMapping("/sportsEquipment/order")
    public String addBranchEquipmentOrder(@Validated SportsEquipmentOrderAddDto dto, Errors errors, Model model) {
        if (errors.hasErrors()){
            List<String> fieldErrorMessageList = errors.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            model.addAttribute("fieldErrorMessageList", fieldErrorMessageList);
            model.addAttribute("formDto", dto);
            return "/branch/sportsEquipment/order/addForm";
        }
        boolean isSuccess = service.addBranchEquipmentOrder(dto);
        if(isSuccess){
            return "redirect:/branch/sportsEquipment/order/addForm?serverMessage=success";
        }
        return "redirect:/branch/sportsEquipment/order/addForm?serverMessage=fail";
    }

    /** <p>지점 프로그램 달력 페이지 get</p>
     * @param requestDate 기준일자
     * @param model {@link BranchProgramCalendar}
     */
    @GetMapping("/programCalendar/{requestDate}")
    public String getBranchProgramCalendar(
            @PathVariable(name = "requestDate") LocalDate requestDate,
            @SessionAttribute("loginEmployee") LoginEmployee loginEmployee, Model model){

        if(requestDate == null){
            return "redirect:/branch/programCalendar/"+ LocalDate.now();
        }

        BranchProgramCalendar calendar = service.getBranchProgramCalendar(requestDate,loginEmployee.getBranchNo());
        model.addAttribute("calendar", calendar);
        return "/branch/programCalendar";
    }
}
