package com.tree.gdhealth.employee.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.customer.login.LoginMapper;
import com.tree.gdhealth.vo.Employee;

@Service
@Transactional
public class EmpLoginService {
	@Autowired EmpLoginMapper empLoginMapper;

	public int login(Employee employee) {
		int n;
		Integer employeeNoCkResult = empLoginMapper.employeeLoginCk(employee);
		if (employeeNoCkResult == null || employeeNoCkResult == 0) { // customerNo가 널값이면 0으로 대체
			n = 0;
			return n;
		}

		n = empLoginMapper.employeeLoginCk(employee);

		return n;
	}
}
