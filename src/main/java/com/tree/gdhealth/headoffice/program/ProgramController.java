package com.tree.gdhealth.headoffice.program;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.vo.Program;
import com.tree.gdhealth.vo.ProgramDate;
import com.tree.gdhealth.vo.ProgramImg;
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
	public String program() {
		
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

}
