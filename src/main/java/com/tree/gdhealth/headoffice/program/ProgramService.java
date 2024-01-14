package com.tree.gdhealth.headoffice.program;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.vo.Program;
import com.tree.gdhealth.vo.ProgramDate;
import com.tree.gdhealth.vo.ProgramImg;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ProgramService {
	
	// DI
	private final ProgramMapper programMapper;
	
	public List<Map<String, Object>> getProgramList(int beginRow, int rowPerPage) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		List<Map<String, Object>> programList = programMapper.programList(map);
		
		return programList;
		
	}
	
	public int getProgramCnt() {
		
		int programCnt = programMapper.programCnt();
		// 디버깅 
		log.debug("전체 프로그램 수 : " + programCnt);
		
		return programCnt;
	}
	
	public List<Map<String, Object>> getSearchList(int beginRow, int rowPerPage, 
			String type, String keyword) {

		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("type", type);
		map.put("keyword", keyword);
		
		List<Map<String, Object>> searchList = programMapper.programList(map);
		
		return searchList;
		
	}
	
	public int getSearchCnt(String type, String keyword) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("keyword", keyword);
		
		int searchCnt = programMapper.searchCnt(map);
		// 디버깅
		log.debug("검색 결과 개수 : " + searchCnt);
		
		return searchCnt;
		
	}
	
	public Map<String, Object> getProgramOne(int programNo, String programDate) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("programNo", programNo);
		map.put("programDate", programDate);
		
		Map<String, Object> programOne = programMapper.programOne(map);
		
		return programOne;
	}
	
	public boolean checkDatesExists(List<String> programDates) {
		
		boolean checkDatesExists = programMapper.checkDatesExists(programDates);
		// 디버깅
		log.debug("dates 존재 확인(존재:true,존재x:false) : " + checkDatesExists);
		
		return checkDatesExists;
	}
	
	public boolean checkDateOneExists(String programDate) {
		
		boolean checkDateOneExists = programMapper.checkDateOneExists(programDate);
		// 디버깅
		log.debug("dateOne 존재 확인(존재:true,존재x:false) : " + checkDateOneExists);
		
		return checkDateOneExists;
	}
	
	public void insertProgram(Program program, ProgramDate programDate, MultipartFile programFile,
									String path) {
		
		/////////////////// 로그인 기능 구현 전 임시 코드 start//////////////////////////
		program.setEmployeeNo(1);
		/////////////////// 로그인 기능 구현 전 임시 코드 end////////////////////////////
		
		int result = programMapper.insertProgram(program);
		// 디버깅
		log.debug("program 추가(성공:1) : " + result);	
		
		// programMapper.xml에서 selectKey로 얻어 온 program table의 auto increment 값
		List<String> dates = programDate.getProgramDates();
		log.debug("dates : " + dates);
		
		Set<String> set = new HashSet<>(dates);
		// dates내에 서로 중복된 값이 있을 때
		if(dates.size() != set.size()) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException();
		}
		
		List<ProgramDate> dateList = new ArrayList<>();
		for(String date : dates) {
			if(!date.equals("")) { // list의 요소가 공백이 아닐 경우
				ProgramDate p = new ProgramDate();
				p.setProgramNo(program.getProgramNo());
				p.setProgramDate(date);
				dateList.add(p);
			}
		}	
						
		int dateResult = programMapper.insertProgramDates(dateList);
		log.debug("programDate 추가(추가 개수) : " + dateResult);	

		if(dateResult == 0) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException(); 
		}

		// 이미지 추가
		if(!programFile.isEmpty()) { // 업로드한 이미지 파일이 하나이상 있다면
			// 파일 저장
			programImgSave(programFile, path, program.getProgramNo());
		}
		
	}
	
	public void updateProgram(Program program, ProgramDate programDate, MultipartFile programFile,
			String path, String oldPath) {

		int result = programMapper.updateProgram(program);
		log.debug("프로그램 수정(성공:1) : " + result);

		int dateResult = programMapper.updateProgramDate(programDate);
		log.debug("프로그램 date 수정(성공:1) : " + dateResult);
			
		if(!programFile.isEmpty()) {
		
			// 기존 파일 삭제
			File file = new File(oldPath);
			boolean isDelete = file.delete();
			// 디버깅
			log.debug("기존 파일 삭제 여부 : " + isDelete);
			
			// 수정한 파일 저장
			programImgUpdate(programFile, path, program.getProgramNo());
		}
	
	}
	
	public int deactiveProgram(int programNo) {
		
		int result = programMapper.deactiveProgram(programNo);
		// 디버깅
		log.debug("프로그램 비활성화(성공:1,실패:0) : " + result);
		
		return result;
	}
	
	public int activeProgram(int programNo) {
		
		int result = programMapper.activeProgram(programNo);
		// 디버깅
		log.debug("프로그램 활성화(성공:1,실패:0) : " + result);
		
		return result;
	}
	
	public void programImgSave(MultipartFile programFile, String path, int programNo) {
		
		ProgramImg img= new ProgramImg();
		img.setProgramNo(programNo);
		img.setOriginName(programFile.getOriginalFilename());
		img.setProgramImgSize(programFile.getSize());
		img.setProgramImgType(programFile.getContentType());

		// fileName : 임의의 문자 생성(유일한 식별자)
		String uName = UUID.randomUUID().toString(); // 파일이름
		
		String oName = programFile.getOriginalFilename();
		// lastIndexOf : parameter로 전달받은 문자열을 원본 문자열의 뒤에서부터 탐색하여, 
		// 처음으로 파라미터의 문자열이 나오는 index를 리턴한다.
		// 확장자 구하기 : xx.xxx.pdf -> .pdf
		String extName = oName.substring(oName.lastIndexOf(".")); 
		log.debug("확장자 : " + extName);
		
		// 이미지 파일이 아니면 rollback
		if(!(extName.equals(".png") || extName.equals(".jpg") || 
				extName.equals(".jpeg") || extName.equals(".gif") || extName.equals(".webp"))) {
			// 강제로 예외를 발생시켜 애노테이션 @Transactional이 작동되게 한다.
			throw new RuntimeException();
		}
		
		img.setFilename(uName + extName);
		
		int imgResult = programMapper.insertProgramImg(img);
		log.debug("programImg 추가(성공:1) : " + imgResult);
		
		// 물리적file을 원하는 경로(path)에 저장
		File file = new File(path+"/"+uName+extName); // 빈파일
		try {
			programFile.transferTo(file); // 물리적으로 파일 업로드가 됨.
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void programImgUpdate(MultipartFile programFile, String path, int programNo) {
		
		ProgramImg img= new ProgramImg();
		img.setProgramNo(programNo);
		img.setOriginName(programFile.getOriginalFilename());
		img.setProgramImgSize(programFile.getSize());
		img.setProgramImgType(programFile.getContentType());

		// fileName : 임의의 문자 생성(유일한 식별자)
		String uName = UUID.randomUUID().toString(); // 파일이름
		
		String oName = programFile.getOriginalFilename();
		// lastIndexOf : parameter로 전달받은 문자열을 원본 문자열의 뒤에서부터 탐색하여, 
		// 처음으로 파라미터의 문자열이 나오는 index를 리턴한다.
		// 확장자 구하기 : xx.xxx.pdf -> .pdf
		String extName = oName.substring(oName.lastIndexOf(".")); 
		log.debug("확장자 : " + extName);
		
		// 이미지 파일이 아니면 rollback
		if(!(extName.equals(".png") || extName.equals(".jpg") || 
				extName.equals(".jpeg") || extName.equals(".gif") || extName.equals(".webp"))) {
			// 강제로 예외를 발생시켜 애노테이션 @Transactional이 작동되게 한다.
			throw new RuntimeException();
		}

		img.setFilename(uName + extName);
		
		int imgResult = programMapper.updateProgramImg(img);
		log.debug("programImgUpdate 추가(성공:1) : " + imgResult);
		
		// 물리적file을 원하는 경로(path)에 저장
		File file = new File(path+"/"+uName+extName); // 빈파일
		try {
			programFile.transferTo(file); // 물리적으로 파일 업로드가 됨.
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
