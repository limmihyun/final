package com.tree.gdhealth.program;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.headoffice.program.ProgramMapper;
import com.tree.gdhealth.vo.Program;

@Transactional
@SpringBootTest
public class IntegrationTest {
	
	@Autowired ProgramMapper programMapper;
	
	@Test
	@DisplayName("program DB에 데이터가 추가되는지 확인") // 테스트 후 자동으로 롤백
	void insertProgram() {
		
		// given(준비)
		Program p = new Program(); 
		p.setEmployeeNo(2);
		p.setProgramName("유산소");
		p.setProgramDetail("유산소 운동입니다.");
		p.setProgramMaxCustomer(10);
		
		// when(실행)
		int result = programMapper.insertProgram(p);
		
		// then(검증)
		assertThat(result).isEqualTo(1);
	}
	
	

}
