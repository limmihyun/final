package com.tree.gdhealth.headoffice.notice;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/notice")
	public String notice() {
		
		return "headoffice/notice";
	}
}
