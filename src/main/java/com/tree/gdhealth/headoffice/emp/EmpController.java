package com.tree.gdhealth.headoffice.emp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class EmpController {
	
	private final EmpService empService;

	@GetMapping("/emp")
	public String notice(Model model) {
		
		List<Map<String,Object>> empList = empService.getEmployeeList();
		
		model.addAttribute("empList", empList);
		
		return "headoffice/emp";
		
	}
	
	@GetMapping("/emp/addEmp") 
	public String addNotice() {
		
		return "headoffice/addEmp";
		
	}
}
