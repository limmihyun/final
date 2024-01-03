package com.tree.gdhealth.headoffice.program;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Program;
import com.tree.gdhealth.vo.ProgramDate;
import com.tree.gdhealth.vo.ProgramImg;
import com.tree.gdhealth.vo.ProgramManager;


@Mapper
public interface ProgramMapper {
	
	int insertProgram(Program program);
	int insertProgramDate(ProgramDate programDate);
	int insertProgramManager(ProgramManager programManager);
	int insertProgramImg(ProgramImg programImg);

}
