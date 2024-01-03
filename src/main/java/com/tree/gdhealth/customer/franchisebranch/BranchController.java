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
		// 지점리스트
		List<Branch> branch = branchService.branchInfo();
		model.addAttribute("branch", branch);
		
		// 전 지점 인원수
		Branch cnt = branchService.branchMemberCnt();
		// 인원수 임의로 값 넣기 
		// cnt.setCount(1000);
		model.addAttribute("cnt", cnt);
		
		System.out.println(branch.toString());
		return "customer/franchiseBranch";
	}
	
	@ResponseBody
	@PostMapping("/customer/branchCk")
	public Branch branchInfoOne(Branch branch) {
		Branch data = branchService.branchInfoOne(branch);
		return data;
	}
}
