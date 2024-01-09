package com.tree.gdhealth.branch.api;

import com.tree.gdhealth.vo.Branch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 정인호
 */
@Mapper
public interface BranchApiMapper {

    Branch selectBranchOneByBranchNo(int branchNo);

    List<Branch> selectBranchAll();
}
