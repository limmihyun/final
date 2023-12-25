package com.tree.gdhealth.branch.sportsequipment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정인호
 * root: /branch/sports-equipment
 *
 */
@Slf4j
@RequestMapping("/branch/sports-equipment")
@Controller
public class BranchSportsEquipmentController {
    @GetMapping("/order")
    public String getOrderForm(Model model){
        model.addAttribute("bodyPath","sports-equipment/orderForm.jsp");
        model.addAttribute("test","1234");
        return "branch/bluePrint";
    }
}
