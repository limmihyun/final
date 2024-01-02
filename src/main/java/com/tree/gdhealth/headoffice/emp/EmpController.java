package com.tree.gdhealth.headoffice.emp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.Paging;
import com.tree.gdhealth.vo.Employee;
import com.tree.gdhealth.vo.EmployeeDetail;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class EmpController {
	
	private final EmpService empService;

	@GetMapping("/emp")
	public String emp(Model model, @RequestParam("num") int num) {
			
		// 직원수
		int cnt = empService.getEmployeeCnt(); 
		
		Paging paging = new Paging();
		paging.setNum(num);
		paging.setCnt(cnt);
		
		List<Map<String, Object>> empList = empService.getEmployeeList(paging.getDisplayPost(), paging.getPostNum());
		
		model.addAttribute("empList", empList);   
		model.addAttribute("lastPage", paging.getLastPage());
		model.addAttribute("currentNum", num);
	
		model.addAttribute("startPageNum", paging.getStartPageNum());
		model.addAttribute("endPageNum", paging.getEndPageNum());
		 
		model.addAttribute("prev", paging.getPrev());
		model.addAttribute("next", paging.getNext());  
	
	    return "headoffice/empList";
		
	}
	
	@ResponseBody
	@GetMapping("/addEmpIdCheck")
	public int addEmpIdCheck(String employeeId) {
		
		int result = empService.idCheck(employeeId);
		
		log.debug("아이디 중복 체크(중복o:1,중복x:0) : " + result);
		
		return result;
	}
	
	@GetMapping("/emp/addEmp") 
	public String addEmp(HttpSession session) {
				
		return "headoffice/addEmp";
		
	}
	
	@PostMapping("/emp/addEmp")
	public String addEmp(HttpSession session, Employee employee, 
							EmployeeDetail employeeDetail, MultipartFile employeeFile) {
		
		String path = session.getServletContext().getRealPath("/upload/emp");
		// 디버깅
		log.debug("저장 경로 : " + path);
		empService.insertEmployee(employee, employeeDetail, employeeFile, path);
		
		return "redirect:/emp";
	}
	
	@GetMapping("/emp/empOne")
	public String empOne(Model model, String employeeId) {
		
		Map<String, Object> employeeOne = empService.getEmployeeOne(employeeId);
		model.addAttribute("empOne",employeeOne);
		
		return "headoffice/empOne";
	}
	
}
