package com.tree.gdhealth.headoffice.emp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeDetail;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeImg;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class EmpController {
	
	private final EmpService empService;

	@GetMapping("/emp")
	public String emp(HttpSession session, Model model) {
		
		List<Map<String,Object>> empList = empService.getEmployeeList();		
		model.addAttribute("empList", empList);
		
		String path = session.getServletContext().getRealPath("/WEB-INF/upload/emp");
		model.addAttribute("path", path);
		
		return "headoffice/empList";
		
	}
	
	@GetMapping("/emp/addEmp") 
	public String addEmp(HttpSession session) {
				
		return "headoffice/addEmp";
		
	}
	
	@PostMapping("/emp/addEmp")
	public String addEmp(HttpSession session, Employee employee, 
							EmployeeDetail employeeDetail, MultipartFile employeeFile) {
		
		String path = session.getServletContext().getRealPath("/WEB-INF/upload/emp");
		
		empService.insertEmployee(employee, employeeDetail, employeeFile, path);
		
		return "redirect:/emp";
	}
}
