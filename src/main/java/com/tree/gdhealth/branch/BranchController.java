package com.tree.gdhealth.branch;

import com.tree.gdhealth.program.dto.BranchProgramCalendar;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderAddRequestDto;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderInformation;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderRetrieveCriteria;
import com.tree.gdhealth.utils.pagination.PageUri;
import com.tree.gdhealth.utils.pagination.PaginationUriGenerator;
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

import java.time.LocalDate;
import java.util.List;

/**
 * <p>지점(branch)의 메인 컨트롤러</p>
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/branch")
@Controller
public class BranchController {
    private final BranchServiceFacade serviceFacade;
    private final PaginationUriGenerator paginationUriGenerator;

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
        LoginEmployee loginEmployee = serviceFacade.testEmployeeLogin(employee);
        session.setAttribute("loginEmployee", loginEmployee);
        return "redirect:/branch/home";
    }

    /**
     * @param loginEmployee 로그인된 직원
     * @return 지점의 직원리스트 페이지
     */
    @GetMapping("/employee/list")
    public String getBranchEmployeeList(@SessionAttribute LoginEmployee loginEmployee, Model model){
        model.addAttribute("branchEmployeeList", serviceFacade.getBranchEmployeeList(loginEmployee.getBranchNo()));
        return "/branch/employee/list";
    }

    /**@return 지점의 물품발주조회 페이지
     * @param requestPage (쿼리스트링)요청 페이지번호
     * @param isOnlyWaitingList (쿼리스트링)대기건만 조회할 것인지 여부
     * @apiNote  출력정보와 페이지네이션 정보
     */
    @GetMapping("/sportsEquipment/order/list")
    public String getBranchSportsEquipmentOrderList(
            @ModelAttribute @RequestParam(name = "requestPage", defaultValue = "1") Integer requestPage,
            @RequestParam(name = "isOnlyWaitingList", defaultValue = "false") boolean isOnlyWaitingList,
            @SessionAttribute("loginEmployee") LoginEmployee loginEmployee,
            Model model) {

        SportsEquipmentOrderRetrieveCriteria criteria = SportsEquipmentOrderRetrieveCriteria.builder()
                .requestPage(requestPage)
                .isOnlyWaitingList(isOnlyWaitingList)
                .branchNo(loginEmployee.getBranchNo())
                .rowPerPage(10).build();

        List<SportsEquipmentOrderInformation> orderInformationList = serviceFacade.getBranchSportsEquipmentOrderList(criteria);
        List<PageUri> pageUriList = serviceFacade.getBranchSportsEquipmentOrderListPagination(
                criteria, "/branch/sportsEquipment/order/list");

        model.addAttribute("orderInformationList", orderInformationList);
        model.addAttribute("pageUriList", pageUriList);
        model.addAttribute("requestPage", requestPage);
        return "/branch/sportsEquipment/order/list";
    }

    /**
     * @return 지점물품발주 폼 페이지
     */
    @GetMapping("/sportsEquipment/order/addForm")
    public String getBranchEquipmentOrderAddForm(@SessionAttribute("loginEmployee") LoginEmployee loginEmployee, Model model) {
        SportsEquipmentOrderAddRequestDto dto = new SportsEquipmentOrderAddRequestDto(loginEmployee.getEmployeeNo(), loginEmployee.getBranchNo(), null, null, null);
        model.addAttribute("formDto", dto);
        return "branch/sportsEquipment/order/addForm";
    }

    /**<p>지점물품발주 post</p>
     * @param dto {@link SportsEquipmentOrderAddRequestDto} 필드 유효성검사
     * @return 지점 물품 주문 폼 페이지에 메세지를 쿼리스트링 추가하여 리다이렉트
     */
    @PostMapping("/sportsEquipment/order")
    public String addBranchEquipmentOrder(@Validated SportsEquipmentOrderAddRequestDto dto, Errors errors, Model model) {
        if (errors.hasErrors()){
            List<String> fieldErrorMessageList = errors.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            model.addAttribute("fieldErrorMessageList", fieldErrorMessageList);
            model.addAttribute("formDto", dto);
            return "/branch/sportsEquipment/order/addForm";
        }
        boolean isSuccess = serviceFacade.addBranchEquipmentOrder(dto);
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

        BranchProgramCalendar calendar = serviceFacade.getBranchProgramCalendar(requestDate,loginEmployee.getBranchNo());
        model.addAttribute("calendar", calendar);
        return "/branch/programCalendar";
    }
}
