package com.tree.gdhealth.branch.sportsequipment;

import com.tree.gdhealth.vo.Employee;
import jakarta.servlet.http.HttpServletRequest;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 * <p>root: /branch/sports-equipment</p>
 */
@Slf4j
@RequestMapping("/branch/sports-equipment")
@RequiredArgsConstructor
@Controller
public class BranchSportsEquipmentController {
    final BranchSportsEquipmentService service;

    @ModelAttribute
    private void mockLoginEmployee(HttpSession session) {
        Employee employee = new Employee();
        employee.setBranchNo(2);
        employee.setEmployeeId("gasan1manager");
        employee.setEmployeeActive("Y");
        employee.setEmployeeNo(2);
        session.setAttribute("loginEmployee", employee);
    }

    /**
     * @param requestPage 쿼리스트링의 요청페이지번호
     * @param isOnlyWaitingList 발주상태가 대기인 것만 추출할 것인지 여부
     * @apiNote {@link getOrderListResponseDto} 에 출력정보와 페이지네이션 정보가 함께 들어있습니다.
     */
    @GetMapping("/list")
    public String getOrderList(
            @RequestParam(name = "requestPage", defaultValue = "1") int requestPage,
            @RequestParam(name = "isOnlyWaitingList", defaultValue = "false") boolean isOnlyWaitingList,
            @SessionAttribute Employee loginEmployee,
            HttpServletRequest request, Model model) {

        getOrderListResponseDto orderListResponseDto = service.getOrderListResponseDto(
                loginEmployee.getBranchNo(),
                requestPage,
                isOnlyWaitingList);
        /*페이지네이션 URI 리스트 생성 시작*/
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        uriComponentsBuilder.path("/branch/sports-equipment/list")
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
        return "/branch/sports-equipment/list";
    }

    @GetMapping("/order")
    public String getOrderForm(@SessionAttribute Employee loginEmployee, Model model) {
        SportsEquipmentOrderAddDto dto = new SportsEquipmentOrderAddDto(
                loginEmployee.getEmployeeNo(),
                loginEmployee.getBranchNo(),
                null,
                null,
                null
        );
        model.addAttribute("formDto", dto);
        return "/branch/sports-equipment/order";
    }

    @PostMapping("/order")
    public String addOrder(@Validated SportsEquipmentOrderAddDto dto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            List<String> fieldErrorMessageList = errors.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            model.addAttribute("fieldErrorMessageList", fieldErrorMessageList);
            model.addAttribute("formDto", dto);
            return "/branch/sports-equipment/order";
        }
        boolean isSuccess = service.addOrder(dto);
        if(isSuccess){
            return "redirect:/branch/sports-equipment/order?serverMessage=success";
        }
        return "redirect:/branch/sports-equipment/order?serverMessage=fail";
    }
}
