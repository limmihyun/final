package com.tree.gdhealth.branch.programcalendar;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramCalendar;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.vo.Employee;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**<p></p>
 * @author 정인호
 */
@Slf4j
@RequestMapping("/branch/program-calendar")
@RequiredArgsConstructor
@Controller
public class BranchProgramCalendarController {
    private final BranchProgramCalendarService service;

    @GetMapping("/home")
    public String getHome(){
        return "redirect:/branch/program-calendar/"+LocalDate.now();
    }

    @GetMapping("/{requestDate}")
    public String getHomeSpecifiedDate(
            @SessionAttribute("loginEmployee") LoginEmployee loginEmployee,
            Model model, @PathVariable("requestDate") LocalDate requestDate){
        BranchProgramCalendar calendar = service.getBranchProgramCalendar(requestDate,loginEmployee.getBranchNo());
        model.addAttribute("calendar", calendar);
        return "/branch/program-calendar/home";
    }


}
