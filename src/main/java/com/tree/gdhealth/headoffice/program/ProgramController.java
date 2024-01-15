package com.tree.gdhealth.headoffice.program;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tree.gdhealth.headoffice.Paging;
import com.tree.gdhealth.headoffice.customValidation.group.DateGroup;
import com.tree.gdhealth.headoffice.customValidation.group.DatesGroup;
import com.tree.gdhealth.vo.Program;
import com.tree.gdhealth.vo.ProgramDate;
import com.tree.gdhealth.vo.ProgramImg;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/headoffice/program")
@RequiredArgsConstructor
@Controller
public class ProgramController {
	
	// DI 
	private final ProgramService programService;
	
	@GetMapping
	public String program() {
		
		return "headoffice/programList";
	}
	
	@GetMapping("/paging")
	public String paging(Model model, int page) {
		
		// 전체 프로그램 수
		int programCnt = programService.getProgramCnt();
		// 디버깅
		log.debug("전체 프로그램 수 : " + programCnt);
		
		// 페이징
		Paging paging = Paging.builder()
				.pageNumCnt(10) // 한번에 표시할 페이징 번호의 갯수
				.rowPerPage(8) // 한 페이지에 나타낼 row 수
				.currentPage(page) // 현재 페이지
				.cnt(programCnt) // 전체 row 수
				.build();
		paging.calculation();
		
		List<Map<String, Object>> programList = programService.getProgramList(paging.getBeginRow(), paging.getRowPerPage());	
		model.addAttribute("programList", programList);  
		
		// 페이징(model 추가)
		paging.pagingAttributes(model, paging, page);
						
		return "headoffice/fragment/program";
		
	}
	
	@GetMapping("/searchPaging")
	public String searchPaging(Model model, String type, String keyword, int page) {
		
		// 검색 결과 개수
		int searchCnt = programService.getSearchCnt(type, keyword);
		// 디버깅
		log.debug("검색 결과 개수(searchPaging) " + searchCnt);
		
		// 페이징
		Paging paging = Paging.builder()
				.pageNumCnt(10) // 한번에 표시할 페이징 번호의 갯수
				.rowPerPage(8) // 한 페이지에 나타낼 row 수
				.currentPage(page) // 현재 페이지
				.cnt(searchCnt) // 전체 row 수
				.build();
		paging.calculation();
		
		List<Map<String, Object>> searchList = programService.getSearchList(paging.getBeginRow(), paging.getRowPerPage(), type, keyword);
		model.addAttribute("programList", searchList);  
		
		// 페이징(model 추가)
		paging.pagingAttributes(model, paging, page); 
		
		// search parameter 추가
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
		return "headoffice/fragment/searchProgram";
		
	}
	
	@GetMapping("/addProgram")
	public String addProgram() {
		
		return "headoffice/addProgram";
	}
	
	@ResponseBody
	@PostMapping("/datesCheck") 
	public boolean dateCheck(@RequestBody List<String> programDates) { 
		// @RequestBody : HTTP 메시지 바디 정보(클라이언트에서 전송한 JSON 형식의 데이터)를 자바 객체로 변환해 준다.
				
		boolean checkDatesExists = programService.checkDatesExists(programDates);
		// 디버깅
		log.debug("선택한 날짜들이 이미 존재하는지 확인(존재:true,존재x:false) : " + checkDatesExists);
		
		return checkDatesExists;
				
	}
	
	@ResponseBody
	@PostMapping("/dateOneCheck")
	public boolean dateOneCheck(String programDate) {
		
		boolean checkDateOneExists = programService.checkDateOneExists(programDate);
		// 디버깅
		log.debug("선택한 날짜가 이미 존재하는지 확인(존재:true,존재x:false) : " + checkDateOneExists);
		
		return checkDateOneExists;
	}
	
	@PostMapping("/addProgram")
	public String addProgram(@Validated Program program, BindingResult bindingResult1,
								@Validated(DatesGroup.class) ProgramDate programDate, 
								BindingResult bindingResult2,
								@Validated ProgramImg programImg, BindingResult bindingResult3,
								HttpSession session) {
		
		// 첫 번째 객체(Program)의 유효성 검증 실패시 처리
		if(bindingResult1.hasErrors()) {
			
			// 에러 메시지 출력
	        for (ObjectError error : bindingResult1.getAllErrors()) {
	        	log.debug("program 객체 validation 실패 : " + error.getDefaultMessage());
	        }
			
			return "headoffice/addProgram";
		}
				
		// 두 번째 객체(ProgramDate)의 유효성 검증 실패시 처리
		if(bindingResult2.hasErrors()) {
			
			// 에러 메시지 출력
	        for (ObjectError error : bindingResult2.getAllErrors()) {
	        	log.debug("programDate 객체 validation 실패 : " + error.getDefaultMessage());
	        }
	        
			return "headoffice/addProgram";
		}
		
		// 세 번째 객체(ProgramDate)의 유효성 검증 실패시 처리
		if(bindingResult3.hasErrors()) {
			
			// 에러 메시지 출력
	        for (ObjectError error : bindingResult3.getAllErrors()) {
	        	log.debug("programImg 객체 validation 실패 : " + error.getDefaultMessage());
	        }
	        
			return "headoffice/addProgram";
		}
		
		String path = session.getServletContext().getRealPath("/upload/program");
		// 디버깅
		log.debug("저장 경로 : " + path);
		programService.insertProgram(program, programDate, programImg, path);
		
		return "redirect:/headoffice/program";
	}
	
	@GetMapping("/programOne/{programNo}/{programDate}")
	public String programOne(Model model, @PathVariable int programNo, 
											@PathVariable String programDate) {
		
		Map<String, Object> programOne = programService.getProgramOne(programNo, programDate);
		// 디버깅
		log.debug("프로그램 상세 정보 : " + programOne);
		model.addAttribute("programOne",programOne);
		
		return "headoffice/programOne";
	}
	
	@GetMapping("/update/{programNo}/{programDate}")
	public String update(Model model, @PathVariable int programNo, 
									@PathVariable String programDate) {
		
		Map<String, Object> programOne = programService.getProgramOne(programNo, programDate);
		// 디버깅
		log.debug("프로그램 상세 정보 : " + programOne);
		model.addAttribute("programOne", programOne);
		
		return "headoffice/updateProgram"; 
	}
	
	@PostMapping("/update")
	public String update(@Validated Program program, BindingResult bindingResult1, 
							@Validated(DateGroup.class) ProgramDate programDate, 
							BindingResult bindingResult2, 
							@Validated ProgramImg programImg, BindingResult bindingResult3,
			HttpSession session, RedirectAttributes redirectAttributes) {
		
		int programNo = program.getProgramNo();
		redirectAttributes.addAttribute("programNo", programNo);
		
		String originDate;
		// 첫 번째 객체(Program)의 유효성 검증 실패시 처리
		if(bindingResult1.hasErrors()) {
			
			originDate = programDate.getOriginDate();
			redirectAttributes.addAttribute("originDate", originDate);
			
			// 에러 메시지 출력
	        for (ObjectError error : bindingResult1.getAllErrors()) {
	        	log.debug("program 객체 validation 실패 : " + error.getDefaultMessage());
	        }
			
			return "redirect:/headoffice/program/update/{programNo}/{originDate}";
		}
				
		// 두 번째 객체(ProgramDate)의 유효성 검증 실패시 error 발생 시 처리
		if(bindingResult2.hasErrors()) {
			
			originDate = programDate.getOriginDate();
			redirectAttributes.addAttribute("originDate", originDate);
			
			// 에러 메시지 출력
	        for (ObjectError error : bindingResult2.getAllErrors()) {
	        	log.debug("programDate 객체 validation 실패 : " + error.getDefaultMessage());
	        }
	        
			return "redirect:/headoffice/program/update/{programNo}/{originDate}";
		}
		
		// 세 번째 객체(ProgramImg)의 유효성 검증 실패시 error 발생 시 처리
		if(bindingResult3.hasErrors()) {
			
			originDate = programDate.getOriginDate();
			redirectAttributes.addAttribute("originDate", originDate);
			
			// 에러 메시지 출력
	        for (ObjectError error : bindingResult3.getAllErrors()) {
	        	log.debug("programImg 객체 validation 실패 : " + error.getDefaultMessage());
	        }
	        
			return "redirect:/headoffice/program/update/{programNo}/{originDate}";
		}
		
		String oldPath = session.getServletContext().getRealPath("/upload/program/" + programImg.getFilename());
		String path = session.getServletContext().getRealPath("/upload/program");
		
		programService.updateProgram(program, programDate, programImg, path, oldPath);
		
		String date = programDate.getProgramDate();
		redirectAttributes.addAttribute("programDate", date);
		
		return "redirect:/headoffice/program/programOne/{programNo}/{programDate}";
	}
	
	@GetMapping("/deactive/{programNo}/{programDate}")
	public String deactive(HttpSession session, @PathVariable int programNo,
									@PathVariable String programDate) {
		
		int result = programService.deactiveProgram(programNo);
		// 디버깅
		log.debug("프로그램 비활성화(성공:1,실패:0) : " + result);
		
		return "redirect:/headoffice/program/programOne/{programNo}/{programDate}";
	}
	
	@GetMapping("/active/{programNo}/{programDate}")
	public String active(HttpSession session, @PathVariable int programNo,
									@PathVariable String programDate) {
		
		int result = programService.activeProgram(programNo);
		// 디버깅
		log.debug("프로그램 활성화(성공:1,실패:0) : " + result);
		
		return "redirect:/headoffice/program/programOne/{programNo}/{programDate}";
	}

}
