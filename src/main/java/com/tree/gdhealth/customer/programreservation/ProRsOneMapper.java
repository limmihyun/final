package com.tree.gdhealth.customer.programreservation;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.customer.programreservation.vo.ProgramReservation;

@Mapper
public interface ProRsOneMapper {
	List<ProgramReservation> proRsOne(Map<String, Object> paramMap);
}
