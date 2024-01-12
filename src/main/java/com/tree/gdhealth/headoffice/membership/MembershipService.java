package com.tree.gdhealth.headoffice.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.Membership;

@Service
@Transactional
public class MembershipService {

	
	@Autowired
	private MembershipMapper membershipMapper;
	
	public List<Membership> membershipList(){
		
		List<Membership> membershipList = membershipMapper.membershipList();
		
		return membershipList;
	}
}
