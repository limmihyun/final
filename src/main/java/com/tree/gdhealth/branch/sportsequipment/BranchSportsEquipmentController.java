package com.tree.gdhealth.branch.sportsequipment;

import com.tree.gdhealth.vo.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    final IBranchSportsEquipmentService service;

    @ModelAttribute
    private void mockLoginEmployee(HttpSession session) {
        Employee employee = new Employee();
        employee.setBranchNo(2);
        employee.setEmployeeId("gasan1manager");
        employee.setEmployeeActive("Y");
        employee.setEmployeeNo(2);
        session.setAttribute("loginEmployee", employee);
    }

    @GetMapping("/list")
    public String getOrderList(
            @RequestParam(name = "requestPage", defaultValue = "1") int requestPage,
            @RequestParam(name = "isOnlyWaitingList", defaultValue = "false") boolean isOnlyWaitingList,
            @SessionAttribute Employee loginEmployee,
            HttpServletRequest request,
            Model model) {

        getOrderListResponseDto orderListResponseDto = service.getOrderListResponseDto(
                loginEmployee.getBranchNo(),
                requestPage,
                isOnlyWaitingList);

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
    public String addOrder(@Valid @ModelAttribute("formDto") SportsEquipmentOrderAddDto dto,
                           Errors errors,
                           Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("formDto", dto);
            return "/branch/sports-equipment/order";
        }
        return null;
    }
}
