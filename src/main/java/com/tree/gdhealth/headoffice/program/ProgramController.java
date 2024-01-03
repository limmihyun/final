package com.tree.gdhealth.headoffice.program;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.Paging;
import com.tree.gdhealth.vo.Program;
import com.tree.gdhealth.vo.ProgramDate;
import com.tree.gdhealth.vo.ProgramManager;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ProgramController {
	
	// DI 
	private final ProgramService programService;
	
	@GetMapping("/program")
	public String program(Model model, @RequestParam(defaultValue = "1") int page) {
		
		// 전체 프로그램 수
		int programCnt = programService.getProgramCnt();
		// 디버깅
		log.debug("전체 프로그램 수 : " + programCnt);
		
		Paging paging = new Paging();
		paging.setRowPerPage(4); // 한 페이지에 나타낼 프로그램 수
		paging.setCurrentPage(page); // 현재 페이지
		paging.setCnt(programCnt); // 전체 직원 수
		
		List<Map<String, Object>> programList = programService.getProgramList(paging.getBeginRow(), paging.getRowPerPage());
		
		model.addAttribute("programList", programList);  
		
		model.addAttribute("lastPage", paging.getLastPage());
		model.addAttribute("currentPage", page);
	
		model.addAttribute("startPageNum", paging.getStartPageNum());
		model.addAttribute("endPageNum", paging.getEndPageNum());
		 
		model.addAttribute("prev", paging.getPrev());
		model.addAttribute("next", paging.getNext());  
		
		return "headoffice/programList";
	}
	
	@GetMapping("/program/addProgram")
	public String addProgram() {
		
		return "headoffice/addProgram";
	}
	
	@PostMapping("/program/addProgram")
	public String addProgram(HttpSession session, Program program, 
								ProgramDate programDate, MultipartFile programFile, 
								ProgramManager programManager) {
		
		String path = session.getServletContext().getRealPath("/upload/program");
		// 디버깅
		log.debug("저장 경로 : " + path);
		programService.insertProgram(program, programDate, programManager, programFile, path);
		
		return "redirect:/program";
	}
	
	@GetMapping("/program/programOne/{programNo}")
	public String programOne(Model model, @PathVariable int programNo) {
		
		Map<String, Object> programOne = programService.getProgramOne(programNo);
		// 디버깅
		log.debug("프로그램 상세 정보 : " + programOne);
		model.addAttribute("programOne",programOne);
		
		return "headoffice/programOne";
	}

}
