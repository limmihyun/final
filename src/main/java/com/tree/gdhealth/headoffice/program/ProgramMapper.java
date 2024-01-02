package com.tree.gdhealth.headoffice.program;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Program;

@Mapper
public interface ProgramMapper {
	
	int insertProgram(Program program);

}
