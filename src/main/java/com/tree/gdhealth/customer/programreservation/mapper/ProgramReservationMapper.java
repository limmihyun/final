package com.tree.gdhealth.customer.programreservation.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProgramReservationMapper {
	
	List<Map<String, Object>> selectProgramByMonth(Map<String, Object> paramMap);
	List<Map<String, Object>> allCalendarList();
}
