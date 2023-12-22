package com.tree.gdhealth.branch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 정인호
 */
@Controller
public class branchHomeController {
    @GetMapping("/branch/2")
    public String getHome(){
        return "/branch/home";
    }
}
