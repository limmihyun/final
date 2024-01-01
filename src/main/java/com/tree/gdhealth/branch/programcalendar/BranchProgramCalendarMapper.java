package com.tree.gdhealth.branch.programcalendar;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 정인호
 */
@Mapper
public interface BranchProgramCalendarMapper {

    List<BranchProgramDate> getProgramDateBetween(
            @Param("branchNo") int branchNo,
            @Param("startDate") LocalDate startDate);
}
