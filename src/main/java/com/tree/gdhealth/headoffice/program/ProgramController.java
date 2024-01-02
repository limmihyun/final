package com.tree.gdhealth.headoffice.program;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramController {
	
	@GetMapping("/program")
	public String program() {
		
		return "headoffice/programList";
	}
	
	@GetMapping("/program/addProgram")
	public String addProgram() {
		
		return "headoffice/addProgram";
	}

}
