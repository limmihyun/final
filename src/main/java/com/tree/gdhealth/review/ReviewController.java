package com.tree.gdhealth.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tree.gdhealth.vo.Customer;
import com.tree.gdhealth.vo.Employee;
import com.tree.gdhealth.vo.Review;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReviewController{
	@Autowired ReviewService reviewService;
	
	@GetMapping("/review/reviewList")
	public String reviewList(Model model) {
		
		List<Review> list = reviewService.reviewList();
		model.addAttribute("list", list);
		
		return "/review/reviewList";
	}
	
	@GetMapping("/review/reviewOne")
	public String reviewOne(Model model, int reviewNo, Review review) {
		Review revuOne = reviewService.reviewOne(reviewNo);
		model.addAttribute("revuOne", revuOne);
		System.out.println("revuOne: " + revuOne);
		
		return "/review/reviewOne";
	}
	
	@PostMapping("/review/reviewOne")
	   public String reviewOne(int reviewNo) {
	      
	      return "redirect:/review/reviewOne?reviewNo=" + reviewNo;
	   }
	
	@GetMapping("/review/addReview")
	public String addReview(HttpSession session, Model model) {
		if(session.getAttribute("customerNo")== null) {
			   return "redirect:/customer/login";
		   }
		
	
		
		int customerNo = ((Customer)session.getAttribute("customerNo")).getCustomerNo();
		   model.addAttribute("customerNo", customerNo);
		   
		
		return "/review/addReview";
	}
	
	/*@GetMapping("/review/deleteReview")
	   public String deleteReview(HttpSession session, Review review) {
		   if(session.getAttribute("employeeNo")== null) {
			   
			   if(session.getAttribute("customerId") == )
			   return "redirect:/customer/login";
		   }
		   int row = reviewService.deleteReview(review);
	    
	       return "redirect:/review/reviewList";
	   }
	   */
	}

