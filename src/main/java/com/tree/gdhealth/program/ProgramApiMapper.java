package com.tree.gdhealth.program;

import com.tree.gdhealth.program.dto.BranchProgramDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Mapper
public interface ProgramApiMapper {

    Map<String, Object> getBranchProgramDate(@Param("date") LocalDate date, @Param("branchNo") int branchNo);

    int selectManager(@Param("programDateNo") int programDateNo,@Param("managerNo") int managerNo);

    int changeManager(@Param("programDateNo") int programDateNo,@Param("managerNo") int managerNo);

    int insertManager(@Param("programDateNo") int programDateNo,@Param("managerNo") int managerNo);

    List<BranchProgramDate> getProgramDateBetween(
            @Param("branchNo") int branchNo,
            @Param("startDate") LocalDate startDate);
}
