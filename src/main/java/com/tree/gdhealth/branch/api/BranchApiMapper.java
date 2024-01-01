package com.tree.gdhealth.branch.api;

import com.tree.gdhealth.vo.Branch;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 정인호
 */
@Mapper
public interface BranchApiMapper {

    Branch getBranchOne(int branchNo);
}
