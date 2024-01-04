package com.tree.gdhealth.headoffice.program;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.management.RuntimeErrorException;

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
	
	public Map<String, Object> getProgramOne(int programNo) {
		
		Map<String, Object> programOne = programMapper.programOne(programNo);
		
		return programOne;
	}
	
	public void insertProgram(Program program, MultipartFile programFile,
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
				
		// 이미지 추가
		if(!programFile.isEmpty()) { // 업로드한 이미지 파일이 하나이상 있다면
			// 파일 저장
			programImgSave(programFile, path, program.getProgramNo());
		}
		
	}
	
	public void updateProgram(Program program, MultipartFile programFile,
			String path, String oldPath) {

		int result = programMapper.updateProgram(program);
		log.debug("프로그램 수정(성공:1,실패:0) : " + result);
		if(result != 1) {
			// insert를 실패하였을 때 강제로 예외를 발생시켜 애노테이션 Transactiona이 작동하도록 한다.
			throw new RuntimeException();
		}
			
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
		// 확장자 구하기
		String extName = oName.substring(oName.lastIndexOf(".")); 
		// xx.xxx.pdf -> .pdf
		img.setFilename(uName + extName);
		
		int imgResult = programMapper.updateProgramImg(img);
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
