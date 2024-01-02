package com.tree.gdhealth.customer.franchisebranch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BranchController {
	@Autowired BranchService branchService;
	
	@GetMapping("/customer/franchiseBranch")
	public String franchiseBranchPage() {
		
		return "customer/franchiseBranch";
	}
	
	@ResponseBody
	@PostMapping("/customer/franchiseBranch")
	public void franchiseBranch() {
		
		
	}
}
