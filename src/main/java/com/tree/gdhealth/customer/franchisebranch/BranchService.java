package com.tree.gdhealth.customer.franchisebranch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.Branch;
import com.tree.gdhealth.vo.CustomerAttendance;

@Service
@Transactional
public class BranchService {
	@Autowired BranchMapper branchMapper;
	
	// 지점 리스트
	public List<Branch> branchInfo() {
		List<Branch> branch = branchMapper.branchInfo();
		return branch;
	}
	
	// 지점 정보, 혼잡도
	public CustomerAttendance attendanceInfo(Branch branch) {
		CustomerAttendance data = branchMapper.attendanceInfo(branch);
		System.out.println(data.getCount());
		return data;
	}
}
