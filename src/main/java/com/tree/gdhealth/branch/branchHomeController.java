package com.tree.gdhealth.branch;

import com.tree.gdhealth.employee.login.EmpLoginService;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.vo.Employee;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
/**
 * @author 정인호
 */
@RequiredArgsConstructor
@Controller
public class branchHomeController {
    private final EmpLoginService empLoginService;
    @GetMapping("/branch/home")
    public String getHome(){
        log.debug("/branch/home");
        return "/branch/home";
    }

    @GetMapping("/testLoginEmployee")
    public String testLogin(HttpSession session){
        Employee employee = new Employee();
        employee.setEmployeeId("gasan1manager");
        employee.setEmployeePw("1234");
        LoginEmployee loginEmployee = empLoginService.login(employee);
        session.setAttribute("loginEmployee", loginEmployee);
        return "/branch/home";
    }
}
