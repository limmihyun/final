package com.tree.gdhealth.headoffice.sportsEquipment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.ImageSave;
import com.tree.gdhealth.utils.enumtype.ImageType;
import com.tree.gdhealth.vo.SportsEquipment;
import com.tree.gdhealth.vo.SportsEquipmentImg;

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
	
	public void insertEquipment(SportsEquipment sportsEquipment, SportsEquipmentImg sportsEquipmentImg, 
										String path) {
		
		/////////////////// 로그인 기능 구현 전 임시 코드 start//////////////////////////
		sportsEquipment.setEmployeeNo(1);
		/////////////////// 로그인 기능 구현 전 임시 코드 end////////////////////////////
		
		if(sportsEquipment.getNote() == null) {
			sportsEquipment.setNote("");
		}
		
		int result = equipmentMapper.insertEquipment(sportsEquipment);
		// 디버깅
		log.debug("equipment 추가(성공:1) : " + result);
		
		int equipmentNo = sportsEquipment.getSportsEquipmentNo();
		MultipartFile equipmentFile = sportsEquipmentImg.getEquipmentFile();
		// 파일 저장
		insertEquipmentImg(equipmentFile, path, equipmentNo);
		
	}
	
	public void insertEquipmentImg(MultipartFile equipmentFile, String path, int equipmentNo) {
		
		ImageSave imgSave = new ImageSave();
		
		SportsEquipmentImg img = new SportsEquipmentImg();
		img.setSportsEquipmentNo(equipmentNo);
		img.setSportsEquipmentImgOriginName(equipmentFile.getOriginalFilename());
		img.setSportsEquipmentImgSize(equipmentFile.getSize());	
		
		ImageType imgType = ImageType.fromText(equipmentFile.getContentType());
		img.setSportsEquipmentImgType(imgType);
		
		String filename = imgSave.getFilename(equipmentFile);
		img.setSportsEquipmentImgFileName(filename);
		
		int imgResult = equipmentMapper.insertEquipmentImg(img);
		log.debug("sportsEquipmentImg 추가(성공:1) : " + imgResult);
		
		// 파일 저장
		imgSave.saveFile(equipmentFile, path, filename);
		
	}
	
	public int deactiveEquipment(int sportsEquipmentNo) {
			
		int result = equipmentMapper.deactiveEquipment(sportsEquipmentNo);
		// 디버깅
		log.debug("물품 비활성화(성공:1,실패:0) : " + result);
		
		return result;
	}
		
	public int activeEquipment(int sportsEquipmentNo) {
		
		int result = equipmentMapper.activeEquipment(sportsEquipmentNo);
		// 디버깅
		log.debug("물품 활성화(성공:1,실패:0) : " + result);
		
		return result;
	}

}
