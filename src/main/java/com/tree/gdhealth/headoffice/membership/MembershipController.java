package com.tree.gdhealth.headoffice.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tree.gdhealth.vo.Membership;

@Controller
public class MembershipController {

	@Autowired
	private MembershipService membershipService;
	
	@GetMapping("/headoffice/membership")
	public String membershipList(Model model) {
		
		List<Membership> membershipList = membershipService.membershipList();
		model.addAttribute("membershipList", membershipList);
		
		return "headoffice/membershipList";
	}
}
