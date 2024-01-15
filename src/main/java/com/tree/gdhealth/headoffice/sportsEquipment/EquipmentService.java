package com.tree.gdhealth.headoffice.sportsEquipment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.vo.SportsEquipment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class EquipmentService {
	
	private final EquipmentMapper equipmentMapper;
	
	public List<Map<String, Object>> getEquipmentList(int beginRow, int rowPerPage) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		List<Map<String, Object>> equipmentList = equipmentMapper.equipmentList(map);
		
		return equipmentList;
	}
	
	public int getEquipmentCnt() {
		
		int equipmentCnt = equipmentMapper.equipmentCnt();
		// 디버깅
		log.debug("전체 물품 수 : " + equipmentCnt);
		
		return equipmentCnt;
		
	}
	
	public List<Map<String, Object>> getSearchList(int beginRow, int rowPerPage, 
													String type, String keyword) {

		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("type", type);
		map.put("keyword", keyword);
		
		List<Map<String, Object>> searchList = equipmentMapper.equipmentList(map);
		
		return searchList;
		
	}
	
	public int getSearchCnt(String type, String keyword) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("keyword", keyword);
		
		int searchCnt = equipmentMapper.searchCnt(map);
		// 디버깅
		log.debug("검색 결과 개수 : " + searchCnt);
		
		return searchCnt;
		
	}
	
	public void insertEquipment(SportsEquipment sportsEquipment, MultipartFile equipmentFile,
									String path) {
		
		/////////////////// 로그인 기능 구현 전 임시 코드 start//////////////////////////
		sportsEquipment.setEmployeeNo(1);
		/////////////////// 로그인 기능 구현 전 임시 코드 end////////////////////////////
		
		int result = equipmentMapper.insertEquipment(sportsEquipment);
		// 디버깅
		log.debug("equipment 추가(성공:1) : " + result);
				
		// file 추가
		if(!equipmentFile.isEmpty()) { // 업로드한 파일이 하나이상 있다면
			// 파일 저장
			// empImgSave(employeeFile, path, employee.getEmployeeNo());
		}
	}

}
