package com.tree.gdhealth.customer.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	private PaymentMapper paymentMapper;
	
	public int addPayment(int membershipNo, int customerNo) {
		
		Map<String, Object> paramap = new HashMap<>();
		paramap.put("membershipNo", membershipNo);
		paramap.put("customerNo", customerNo);
		
		paymentMapper.addPayment(paramap);

		return 1;
	}
}
