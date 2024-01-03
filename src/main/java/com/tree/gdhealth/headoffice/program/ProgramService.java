package com.tree.gdhealth.headoffice.program;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.vo.Program;
import com.tree.gdhealth.vo.ProgramDate;
import com.tree.gdhealth.vo.ProgramImg;
import com.tree.gdhealth.vo.ProgramManager;

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
	
	public void insertProgram(Program program, ProgramDate programDate,
							ProgramManager programManager, MultipartFile programFile,
									String path) {
		
		/////////////////// 로그인 기능 구현 전 임시 코드 start//////////////////////////
		program.setEmployeeNo(1);
		/////////////////// 로그인 기능 구현 전 임시 코드 end////////////////////////////
		
		int result = programMapper.insertProgram(program);
		// 디버깅
		log.debug("program 추가(성공:1,실패:0) : " + result);	
		if(result != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException(); 
		}
		
		// programMapper.xml에서 selectKey로 얻어 온 program table의 auto increment 값
		programDate.setProgramNo(program.getProgramNo());
		int dateResult = programMapper.insertProgramDate(programDate);
		// 디버깅
		log.debug("programDate 추가(성공:1,실패:0) : " + dateResult);
		if(dateResult != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException(); 
		}
		
		// programMapper.xml에서 selectKey로 얻어 온 program_date table의 auto increment 값
		programManager.setProgramDateNo(programDate.getProgramDateNo());
		programManager.setProgramNo(program.getProgramNo());
		
		/////////////////// 로그인 기능 구현 전 임시 코드 start//////////////////////////
		programManager.setEmployeeNo(1);
		/////////////////// 로그인 기능 구현 전 임시 코드 end////////////////////////////
		
		int managerResult = programMapper.insertProgramManager(programManager);
		// 디버깅
		log.debug("programManager 추가(성공:1,실패:0) : " + managerResult);
		if(managerResult != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException(); 
		}
		
		// 이미지 추가
		if(programFile != null) { // 업로드한 이미지 파일이 하나이상 있다면
			// 파일 저장
			programImgSave(programFile, path, program.getProgramNo());
		}
		
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
		// 확장자 구하기
		String extName = oName.substring(oName.lastIndexOf(".")); 
		// xx.xxx.pdf -> .pdf
		img.setFilename(uName + extName);
		
		int imgResult = programMapper.insertProgramImg(img);
		if(imgResult != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException();
		}
		// noticefile 테이블 입력
		
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
