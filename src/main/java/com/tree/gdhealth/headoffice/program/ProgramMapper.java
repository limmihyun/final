package com.tree.gdhealth.headoffice.program;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

import com.tree.gdhealth.vo.Program;
import com.tree.gdhealth.vo.ProgramDate;
import com.tree.gdhealth.vo.ProgramImg;
import com.tree.gdhealth.vo.ProgramManager;


@Mapper
public interface ProgramMapper {
	
	List<Map<String,Object>> programList(Map<String, Object> map);
	int programCnt();
	
	Map<String, Object> programOne(int programNo);
	
	int insertProgram(Program program);
	int insertProgramImg(ProgramImg programImg);
	
	int updateProgram(Program program);
	int updateProgramImg(ProgramImg programImg);
	
	int deactiveProgram(int programNo);
	int activeProgram(int programNo);
	
}
