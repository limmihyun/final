package com.tree.gdhealth.customer.programreservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.customer.programreservation.vo.ProgramReservation;

@Service
@Transactional
public class ProRsOneService {
	@Autowired
	private ProRsOneMapper proRsOneMapper;
	
	public List<ProgramReservation> prorsone(int year, int month, int day, String programName){
		
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("month", String.format("%02d",month + 1));
		paramMap.put("day", String.format("%02d",day));
		paramMap.put("programName", programName);
		
		List<ProgramReservation> resultList = proRsOneMapper.proRsOne(paramMap);
		System.out.println(resultList + "<--resultList 출력 결과");
		
		return resultList;
	}

}
