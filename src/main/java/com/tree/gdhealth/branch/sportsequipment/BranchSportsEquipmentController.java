package com.tree.gdhealth.branch.sportsequipment;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 정인호
 * <p>root: /branch/sports-equipment</p>
 *
 */
@Slf4j
@RequestMapping("/branch/sports-equipment")
@RequiredArgsConstructor
@Controller
public class BranchSportsEquipmentController {
    final IBranchSportsEquipmentService service;

    @ModelAttribute
    private void mockLoginEmployee(HttpSession session){
       Employee employee = new Employee();
       employee.setBranchNo(2);
       employee.setEmployeeId("gasan1manager");
       employee.setEmployeeActive("Y");
       employee.setEmployeeNo(2);
       session.setAttribute("loginEmployee", employee);
    }

    @GetMapping("/order")
    public String getOrderForm(@SessionAttribute Employee loginEmployee, Model model){
            SportsEquipmentOrderAddDto dto = new SportsEquipmentOrderAddDto(
                    loginEmployee.getEmployeeNo(),
                    loginEmployee.getBranchNo(),
                    null,null,null
            );
            model.addAttribute("formDto", dto);
        return "/branch/sports-equipment/order";
    }

    @PostMapping("/order")
    public String addOrder(@Valid @ModelAttribute("formDto") SportsEquipmentOrderAddDto dto,
                           Errors errors,
                           Model model){
        if(errors.hasErrors()){
            model.addAttribute("formDto", dto);
            return "/branch/sports-equipment/order";
        }
        return null;
    }
}
