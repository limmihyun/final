package com.tree.gdhealth.branch.employee;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramCalendar;
import com.tree.gdhealth.employee.api.EmployeeApiService;
import com.tree.gdhealth.vo.Employee;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**<p></p>
 * @author 정인호
 */
@Slf4j
@RequestMapping("/branch/employee")
@RequiredArgsConstructor
@Controller
public class BranchEmployeeController {
    private final EmployeeApiService service;

    @ModelAttribute
    private void mockLoginEmployee(HttpSession session) {
        Employee employee = new Employee();
        employee.setBranchNo(2);
        employee.setEmployeeId("gasan1manager");
        employee.setEmployeeActive("Y");
        employee.setEmployeeNo(2);
        session.setAttribute("loginEmployee", employee);
    }

    @GetMapping("/home")
    public String getHome(@SessionAttribute Employee loginEmployee, Model model){
        List<Map<String,Object>> employeeList = service.getBranchEmployeeList(loginEmployee.getBranchNo());
        model.addAttribute("employeeList", employeeList);
        return "/branch/employee/home";
    }

}
