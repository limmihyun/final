package com.tree.gdhealth.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tree.gdhealth.headoffice.emp.EmpMapper;
import com.tree.gdhealth.headoffice.emp.vo.Employee;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeDetail;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeImg;


@ExtendWith(SpringExtension.class) // 통합테스트(JUnit5)
@MybatisTest
// 현재 연결된 실제 DB로 테스트. Replace.NONE로 설정하면 @ActiveProfiles에 설정한 프로파일 환경값에 따라 데이터 소스가 적용된다.
@AutoConfigureTestDatabase(replace = Replace.NONE) 
public class EmpMapperTest {
	
	@Autowired EmpMapper empMapper;
	
	@Test
	@DisplayName("직원 목록 테스트") // 현재 연결된 실제 DB로 테스트
	void empListTest() {
		
		// given(준비)
		
		// when(실행)
		List<Map<String, Object>> list = empMapper.employeeList();
		
		// then(검증)
		assertThat(list.get(0).get("empName")).isEqualTo("확인용1");
	}
	
	@Test
	@DisplayName("직원 수 테스트") // 현재 연결된 실제 DB로 테스트
	void empCntTest() {
		
		// given(준비)
		
		// when(실행)
		int empCnt = empMapper.employeeCnt();
		
		// then(검증)
		assertThat(empCnt).isEqualTo(8);
	}
	
	@Test
	@DisplayName("직원 상세 정보 테스트") // 현재 연결된 실제 DB로 테스트
	void empOneTest() {
				
		// given(준비)
		String employeeId = "sksmss16";
		
		// when(실행)
		Map<String, Object> one = empMapper.employeeOne(employeeId); 
		
		// then(검증)
		assertThat((String) one.get("empName")).isEqualTo("확인용6");
	}
	
	@Test
	@DisplayName("직원 추가 테스트") // 테스트 후 자동으로 롤백
	void insertEmpTest() {
		
		// given(준비)
		Employee e = new Employee();
		e.setBranchNo(1);
		e.setEmployeeId("goodee");
		e.setEmployeePw("1234");
		
		// when(실행)
		int result = empMapper.insertEmployee(e);
		
		// then(검증)
		assertThat(result).isEqualTo(1);
		
	}
	
	@Test
	@DisplayName("직원Detail 추가 테스트") // 테스트 후 자동으로 롤백
	void insertEmpDetailTest() {
		
		// given(준비)
		EmployeeDetail ed = new EmployeeDetail();
		ed.setEmployeeNo(1);
		ed.setEmployeeName("구디");
		ed.setEmployeePhone("01011111111");
		ed.setEmployeeEmail("goodee@naver.com");
		ed.setEmployeeGender("m");
		
		// when(실행)
		int result = empMapper.insertEmployeeDetail(ed);
		
		// then(검증)
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	@DisplayName("직원Img 추가 테스트") // 테스트 후 자동으로 롤백
	void insertEmpImgTest() {
		
		// given(준비)
		EmployeeImg ei = new EmployeeImg();
		ei.setEmployeeNo(1);
		ei.setEmployeeImgOriginName("origin.png");
		ei.setEmployeeImgFilename("filename.png");
		ei.setEmployeeImgSize(250);
		ei.setEmployeeImgType("png");
			
		// when(실행)
		int result = empMapper.insertEmployeeImg(ei);
		
		// then(검증)
		assertThat(result).isEqualTo(1);
		
	}
}
