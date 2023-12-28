package com.tree.gdhealth.customer.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.vo.Customer;
import com.tree.gdhealth.vo.CustomerSignUp;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignUpController {
	@Autowired private SignUpService signUpService;
	
	
	@GetMapping("/customer/signup")
	public String signUpPage() {
		
		return "customer/signUp";
	}
	
	@PostMapping("/customer/signup")
	public String signUp(HttpSession session,CustomerSignUp custoemrSignUp,@RequestParam("customerImg") MultipartFile imgFile) {
		
		String path = session.getServletContext().getRealPath("/upload/customer");
		

		System.out.println(custoemrSignUp.toString());
		
		// customer INSERT
		signUpService.SignUp(custoemrSignUp,imgFile,path);
		
		return "/customer/login";
	}
	
	@ResponseBody
	@GetMapping("/customer/idCk")
	public Customer idCk(Customer customer) {
		signUpService.idCk(customer);
		
		return customer;
	}
	

	
}
