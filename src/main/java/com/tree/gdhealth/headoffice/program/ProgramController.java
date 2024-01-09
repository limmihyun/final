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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		return "headoffice/programList";
	}
	
	@GetMapping("/paging")
	public String paging(Model model, @RequestParam(defaultValue = "1") int page) {
		
		// 전체 프로그램 수
		int programCnt = programService.getProgramCnt();
		// 디버깅
		log.debug("전체 프로그램 수 : " + programCnt);
		
		// 페이징
		Paging paging = Paging.builder()
				.pageNumCnt(10) // 한번에 표시할 페이징 번호의 갯수
				.rowPerPage(4) // 한 페이지에 나타낼 row 수
				.currentPage(page) // 현재 페이지
				.cnt(programCnt) // 전체 row 수
				.build();
		paging.calculation();
		
		List<Map<String, Object>> searchList = programService.getProgramList(paging.getBeginRow(), paging.getRowPerPage());	
		model.addAttribute("programList", searchList);  
		
		// 페이징(model 추가)
		paging.pagingAttributes(model, paging, page);
						
		return "headoffice/fragment/program";
		
	}
	
	@GetMapping("/searchPaging")
	public String searchPaging(Model model, String type, String keyword, 
									@RequestParam(defaultValue = "1") int page) {
		
		// 검색 결과 개수
		int searchCnt = programService.getSearchCnt(type, keyword);
		// 디버깅
		log.debug("전체 프로그램 수 : " + searchCnt);
		
		// 페이징
		Paging paging = Paging.builder()
				.pageNumCnt(10) // 한번에 표시할 페이징 번호의 갯수
				.rowPerPage(4) // 한 페이지에 나타낼 row 수
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
	
	@PostMapping("/addProgram")
	public String addProgram(HttpSession session, Program program, 
								ProgramDate programDate, MultipartFile programFile) {
		
		String path = session.getServletContext().getRealPath("/upload/program");
		// 디버깅
		log.debug("저장 경로 : " + path);
		programService.insertProgram(program, programDate, programFile, path);
		
		return "redirect:/headoffice/program";
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
	public String update(HttpSession session, MultipartFile programFile, RedirectAttributes redirectAttributes,
							Program program, ProgramDate programDate, ProgramImg programImg) {
				
		String oldPath = session.getServletContext().getRealPath("/upload/program/" + programImg.getFilename());
		String path = session.getServletContext().getRealPath("/upload/program");
		
		programService.updateProgram(program, programDate, programFile, path, oldPath);
		
		int programNo = program.getProgramNo();
		redirectAttributes.addAttribute("programNo", programNo);
		
		return "redirect:/headoffice/program/programOne/{programNo}";
	}
	
	@GetMapping("/deactive/{programNo}")
	public String deactive(HttpSession session, @PathVariable int programNo) {
		
		int result = programService.deactiveProgram(programNo);
		// 디버깅
		log.debug("프로그램 비활성화(성공:1,실패:0) : " + result);
		
		return "redirect:/headoffice/program/programOne/{programNo}";
	}
	
	@GetMapping("/active/{programNo}")
	public String active(HttpSession session, @PathVariable int programNo) {
		
		int result = programService.activeProgram(programNo);
		// 디버깅
		log.debug("프로그램 활성화(성공:1,실패:0) : " + result);
		
		return "redirect:/headoffice/program/programOne/{programNo}";
	}

}
