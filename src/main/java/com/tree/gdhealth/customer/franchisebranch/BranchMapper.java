package com.tree.gdhealth.customer.franchisebranch;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Branch;
import com.tree.gdhealth.vo.CustomerAttendance;

@Mapper
public interface BranchMapper {
	
	List<Branch> branchInfo();
	
	Branch branchMemberCnt();
	
	Branch branchInfoOne(Branch branch);
	
}
