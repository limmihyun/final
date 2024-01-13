package com.tree.gdhealth.headoffice.emp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.vo.Employee;
import com.tree.gdhealth.vo.EmployeeDetail;
import com.tree.gdhealth.vo.EmployeeImg;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class EmpService {
	
	// DI
	private final EmpMapper empMapper;
	
	public List<Map<String, Object>> getEmployeeList(int beginRow, int rowPerPage) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		List<Map<String, Object>> employeeList = empMapper.employeeList(map);
		
		return employeeList;
	}
			
	public int getEmployeeCnt() {
		
		int employeeCnt = empMapper.employeeCnt();
		// 디버깅 
		log.debug("전체 직원 수 : " + employeeCnt);
		
		return employeeCnt;
	}
	
	public List<Map<String, Object>> getSearchList(int beginRow, int rowPerPage, 
													String type, String keyword) {
				
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("type", type);
		map.put("keyword", keyword);
		
		List<Map<String, Object>> searchList = empMapper.employeeList(map);
		
		return searchList;
		
	}
	
	public int getSearchCnt(String type, String keyword) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("type", type);
		
		int searchCnt = empMapper.searchCnt(map);
		// 디버깅
		log.debug("검색 결과 개수 : " + searchCnt);
		
		return searchCnt;
	}
	
	public List<String> getBranchList() {
		
		List<String> branchList = empMapper.branchList();
		// 디버깅
		log.debug("지점 목록 : " + branchList);
		
		return branchList;
	}
	
	public Map<String, Object> getEmployeeOne(String employeeId) {
		
		Map<String, Object> employeeOne = empMapper.employeeOne(employeeId);
		// 디버깅 
		log.debug("직원 상세 정보 : " + employeeOne);
		
		return employeeOne;
	}
	
	public int idCheck(String employeeId) {
		
		int result = empMapper.idCheck(employeeId);
		
		return result;
	}
	
	public void insertEmployee(Employee employee, EmployeeDetail employeeDetail, 
								MultipartFile employeeFile, String path) {
		
		int result = empMapper.insertEmployee(employee);
		// 디버깅
		log.debug("employee 추가(성공:1,실패:0) : " + result);		
		if(result != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException(); 
		}
		
		// empMapper.xml에서 selectKey로 얻어 온 employee table의 auto increment 값
		employeeDetail.setEmployeeNo(employee.getEmployeeNo());
		int detailResult = empMapper.insertEmployeeDetail(employeeDetail);
		// 디버깅
		log.debug("employeeDetail 추가(성공:1,실패:0) : " + detailResult);
		if(detailResult != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException(); 
		}
		
		// file 추가
		if(!employeeFile.isEmpty()) { // 업로드한 파일이 하나이상 있다면
			// 파일 저장
			empImgSave(employeeFile, path, employee.getEmployeeNo());
		}
	
	}
	
	public void empImgSave(MultipartFile employeeFile, String path, int employeeNo) {
		
		EmployeeImg img = new EmployeeImg();
		img.setEmployeeNo(employeeNo);
		img.setEmployeeImgOriginName(employeeFile.getOriginalFilename());
		img.setEmployeeImgSize(employeeFile.getSize());
		img.setEmployeeImgType(employeeFile.getContentType());

		// fileName : 임의의 문자 생성(유일한 식별자)
		String uName = UUID.randomUUID().toString(); // 파일이름
		
		String oName = employeeFile.getOriginalFilename();
		// lastIndexOf : parameter로 전달받은 문자열을 원본 문자열의 뒤에서부터 탐색하여, 
		// 처음으로 파라미터의 문자열이 나오는 index를 리턴한다.
		// 확장자 구하기
		String extName = oName.substring(oName.lastIndexOf(".")); 
		// xx.xxx.pdf -> .pdf
		img.setEmployeeImgFilename(uName + extName);
		
		int imgResult = empMapper.insertEmployeeImg(img);
		if(imgResult != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException();
		}
		// noticefile 테이블 입력
		
		// 물리적file을 원하는 경로(path)에 저장
		File file = new File(path+"/"+uName+extName); // 빈파일
		try {
			employeeFile.transferTo(file); // 물리적으로 파일 업로드가 됨.
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
				
}
