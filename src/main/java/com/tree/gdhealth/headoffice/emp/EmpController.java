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
    	
    	// 한 페이지에 출력할 게시물 갯수
    	int postNum = 8;
    	
    	// 마지막 페이징번호
    	int lastPage = (int) Math.ceil((double)cnt/postNum);
    	
    	// 출력할 게시물
    	int displayPost = (num - 1) * postNum; 
    	
    	// 한번에 표시할 페이징 번호의 갯수
    	int pageNum_cnt = 10;

    	// 표시되는 페이지 번호 중 마지막 번호
    	int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt); 

    	// 표시되는 페이지 번호 중 첫번째 번호
    	int startPageNum = endPageNum - pageNum_cnt + 1; 
    	
    	// 마지막 번호 재계산
    	int endPageNum_tmp = (int)(Math.ceil((double)cnt / (double)postNum)); 
    	 
    	if(endPageNum > endPageNum_tmp) { 
    		endPageNum = endPageNum_tmp; 
    	}
    	
    	boolean prev = startPageNum == 1 ? false : true;
    	boolean next = endPageNum * postNum >= cnt ? false : true; 
    	
    	List<Map<String, Object>> empList = empService.getEmployeeList(displayPost, postNum);
    	model.addAttribute("empList", empList);
    	model.addAttribute("lastPage", lastPage);
    	model.addAttribute("currentNum", num);
    	
    	// 시작 및 끝 번호
    	model.addAttribute("startPageNum", startPageNum);
    	model.addAttribute("endPageNum", endPageNum);

    	// 이전 및 다음 
    	model.addAttribute("prev", prev);
    	model.addAttribute("next", next);
      
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
