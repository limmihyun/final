package com.tree.gdhealth.customer.franchisebranch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tree.gdhealth.vo.Branch;
import com.tree.gdhealth.vo.CustomerAttendance;

import jakarta.servlet.http.HttpSession;

@Controller
public class BranchController {
	@Autowired BranchService branchService;
	
	@GetMapping("/customer/franchiseBranch")
	public String franchiseBranchPage(Model model, HttpSession session) {
		List<Branch> branch = branchService.branchInfo();
		model.addAttribute("branch", branch);
		System.out.println(branch.toString());
		return "customer/franchiseBranch";
	}
	
	@ResponseBody
	@PostMapping("/customer/branchCk")
	public CustomerAttendance attendanceInfo(Branch branch) {
		CustomerAttendance data = branchService.attendanceInfo(branch);
		return data;
	}
}
