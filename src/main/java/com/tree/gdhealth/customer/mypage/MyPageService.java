package com.tree.gdhealth.customer.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyPageService {
	@Autowired MyPageMapper myPageMapper;

}
