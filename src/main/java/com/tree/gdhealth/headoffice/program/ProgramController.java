package com.tree.gdhealth.headoffice.program;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.Paging;
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
	
	@GetMapping("/addProgram")
	public String addProgram() {
		
		return "headoffice/addProgram";
	}
	
	@PostMapping("/addProgram")
	public String addProgram(HttpSession session, Program program, 
								ProgramDate programDate, MultipartFile programFile) {
		
		String path = session.getServletContext().getRealPath("/upload/program");
		// 디버깅
		log.debug("저장 경로 : " + path);
		programService.insertProgram(program, programFile, path);
		
		return "redirect:/program";
	}
	
	@GetMapping("/programOne/{programNo}")
	public String programOne(Model model, @PathVariable int programNo) {
		
		Map<String, Object> programOne = programService.getProgramOne(programNo);
		// 디버깅
		log.debug("프로그램 상세 정보 : " + programOne);
		model.addAttribute("programOne",programOne);
		
		return "headoffice/programOne";
	}
	
	@GetMapping("/update/{programNo}")
	public String update(Model model, @PathVariable int programNo) {
		
		Map<String, Object> programOne = programService.getProgramOne(programNo);
		// 디버깅
		log.debug("프로그램 상세 정보 : " + programOne);
		model.addAttribute("programOne", programOne);
		
		return "headoffice/updateProgram";
	}
	
	@PostMapping("/update")
	public String update(HttpSession session, MultipartFile programFile,
							Program program, ProgramImg programImg) {
				
		String oldPath = session.getServletContext().getRealPath("/upload/program/" + programImg.getFilename());
		String path = session.getServletContext().getRealPath("/upload/program");
		
		programService.updateProgram(program, programFile, path, oldPath);
		
		return "redirect:/program/programOne/" + program.getProgramNo();
	}
	
	@GetMapping("/deactive/{programNo}")
	public String deactive(HttpSession session, @PathVariable int programNo) {
		
		int result = programService.deactiveProgram(programNo);
		// 디버깅
		log.debug("프로그램 비활성화(성공:1,실패:0) : " + result);
		
		return "redirect:/headoffice/program/programOne/" + programNo;
	}
	
	@GetMapping("/active/{programNo}")
	public String active(HttpSession session, @PathVariable int programNo) {
		
		int result = programService.activeProgram(programNo);
		// 디버깅
		log.debug("프로그램 활성화(성공:1,실패:0) : " + result);
		
		return "redirect:/headoffice/program/programOne/" + programNo;
	}

}
