package com.tree.gdhealth.headoffice.customer;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tree.gdhealth.headoffice.Paging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/headoffice/customer")
@RequiredArgsConstructor
@Controller
public class CustomerController {
	
	private final CustomerService customerService;
	
	@GetMapping
	public String customer(Model model, @RequestParam(defaultValue = "1") int page) {
		
		// 전체 고객 수
		int customerCnt = customerService.getCustomerCnt();
		// 디버깅
		log.debug("전체 고객 수 : " + customerCnt);
		
		Paging paging = new Paging();
		paging.setRowPerPage(4); // 한 페이지에 나타낼 직원 수
		paging.setCurrentPage(page); // 현재 페이지
		paging.setCnt(customerCnt); // 전체 직원 수
		
		List<Map<String,Object>> customerList = customerService.getCustomerList(paging.getBeginRow(), paging.getRowPerPage());
		
		model.addAttribute("customerList", customerList);
		model.addAttribute("lastPage", paging.getLastPage());
		model.addAttribute("currentPage", page);
		
		model.addAttribute("startPageNum", paging.getStartPageNum());
		model.addAttribute("endPageNum", paging.getEndPageNum());
		 
		model.addAttribute("prev", paging.getPrev());
		model.addAttribute("next", paging.getNext());  
		
		return "headoffice/customerList";
	}
	
	@GetMapping("/paging")
	public String paging(Model model, @RequestParam(defaultValue = "1") int page) {
		
		// 전체 고객 수
		int customerCnt = customerService.getCustomerCnt();
		// 디버깅
		log.debug("전체 고객 수 : " + customerCnt);
		
		Paging paging = new Paging();
		paging.setRowPerPage(4); // 한 페이지에 나타낼 직원 수
		paging.setCurrentPage(page); // 현재 페이지
		paging.setCnt(customerCnt); // 전체 직원 수
		
		List<Map<String,Object>> customerList = customerService.getCustomerList(paging.getBeginRow(), paging.getRowPerPage());
		
		model.addAttribute("customerList", customerList);
		model.addAttribute("lastPage", paging.getLastPage());
		model.addAttribute("currentPage", page);
		
		model.addAttribute("startPageNum", paging.getStartPageNum());
		model.addAttribute("endPageNum", paging.getEndPageNum());
		 
		model.addAttribute("prev", paging.getPrev());
		model.addAttribute("next", paging.getNext());  
		
		return "headoffice/fragment/customer";
	}
	
	@GetMapping("/search")
	public String search(Model model, String type, String keyword,
								@RequestParam(defaultValue = "1") int page) {
		
		// 검색 결과 개수
		int searchCnt = customerService.getSearchCnt(type, keyword);
		// 디버깅
		log.debug("검색 결과 개수 : " + searchCnt);
		
		Paging paging = new Paging();
		paging.setRowPerPage(4); // 한 페이지에 나타낼 검색 결과 수
		paging.setCurrentPage(page); // 현재 페이지
		paging.setCnt(searchCnt); // 전체 검색 결과 수
		
		List<Map<String, Object>> searchList = customerService.getSearchList(paging.getBeginRow(), paging.getRowPerPage(), type, keyword);
		
		model.addAttribute("customerList", searchList);   
		model.addAttribute("lastPage", paging.getLastPage());
		model.addAttribute("currentPage", page);
	
		model.addAttribute("startPageNum", paging.getStartPageNum());
		model.addAttribute("endPageNum", paging.getEndPageNum());
		 
		model.addAttribute("prev", paging.getPrev());
		model.addAttribute("next", paging.getNext());
		
		// search parameter 추가
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);

		return "headoffice/fragment/searchCustomer";
	}
	
	@GetMapping("/searchPaging")
	public String searchPaging(Model model, String type, String keyword, 
									@RequestParam(defaultValue = "1") int page) {
		
		// 검색 결과 개수
		int searchCnt = customerService.getSearchCnt(type, keyword);
		// 디버깅
		log.debug("전체 프로그램 수 : " + searchCnt);
		
		Paging paging = new Paging();
		paging.setRowPerPage(4); // 한 페이지에 나타낼 프로그램 수
		paging.setCurrentPage(page); // 현재 페이지
		paging.setCnt(searchCnt); // 전체 직원 수
		
		List<Map<String, Object>> searchList = customerService.getSearchList(paging.getBeginRow(), paging.getRowPerPage(), type, keyword);
		
		model.addAttribute("customerList", searchList);  
		
		model.addAttribute("lastPage", paging.getLastPage());
		model.addAttribute("currentPage", page);
	
		model.addAttribute("startPageNum", paging.getStartPageNum());
		model.addAttribute("endPageNum", paging.getEndPageNum());
		 
		model.addAttribute("prev", paging.getPrev());
		model.addAttribute("next", paging.getNext()); 
		
		// search parameter 추가
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
		return "headoffice/fragment/searchCustomer";
		
	}
	
}
