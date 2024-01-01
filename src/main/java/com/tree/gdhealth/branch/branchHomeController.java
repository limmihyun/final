package com.tree.gdhealth.branch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
/**
 * @author 정인호
 */
@Controller
public class branchHomeController {
    @GetMapping("/branch/home")
    public String getHome(){
        log.debug("/branch/home");
        return "/branch/home";
    }
}
