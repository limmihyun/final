package com.tree.gdhealth.headoffice.emp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeDetail;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeImg;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class EmpController {
	
	private final EmpService empService;

	@GetMapping("/emp")
	public String emp(Model model) {
		
		List<Map<String,Object>> empList = empService.getEmployeeList();
		
		model.addAttribute("empList", empList);
		
		return "headoffice/empList";
		
	}
	
	@GetMapping("/emp/addEmp") 
	public String addEmp() {
				
		return "headoffice/addEmp";
		
	}
	
	@PostMapping("/emp/addEmp")
	public String addEmp(Employee employee, EmployeeDetail employeeDetail,
							EmployeeImg employeeImg) {
		
		int result = empService.insertEmployee(employee);
		
		// 디버깅
		log.debug("employee 추가(성공:1,실패:0) : " + result);
		if(result == 1) {
			
			int detailResult = empService.insertEmployeeDetail(employeeDetail);
			
			// 디버깅
			log.debug("employeeDetail 추가(성공:1,실패:0) : " + detailResult);
			
			if(detailResult == 1) {
								
				int imgResult = empService.insertEmployeeImg(employeeImg);
				
				// 디버깅
				log.debug("employeeImg 추가(성공:1,실패:0) : " + imgResult);
			}
		}
		
		return "redirect:/emp";
	}
}
