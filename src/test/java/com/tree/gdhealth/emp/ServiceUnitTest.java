package com.tree.gdhealth.emp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.headoffice.emp.EmpMapper;
import com.tree.gdhealth.headoffice.emp.EmpService;
import com.tree.gdhealth.headoffice.emp.vo.Employee;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeDetail;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeImg;
/*
 * empMapper를 Mock(가짜 객체)으로 하여 Mapper에 영향을 받지 않는 순수한 service로직을 테스트한다.
 * 각각의 테스트 케이스는 의존성을 없애기 위해 Mock 객체(가짜 객체)를 사용하였다.
 * */
@ExtendWith(MockitoExtension.class) 
@Transactional
public class ServiceUnitTest {
	
	@Mock
    private EmpMapper empMapper;
	
	@Spy
	@InjectMocks
	private EmpService empService;
        
    @Test
    @DisplayName("직원들의 목록")
    void empListTest() {
    	
    	// given(준비)
    	Map<String, Object> map1 = new HashMap<>();
    	map1.put("empId", "goodee");
    	
    	Map<String, Object> map2 = new HashMap<>();
    	map2.put("empId", "goodee2");
    	
    	List<Map<String, Object>> listGiven = new ArrayList<>();
    	listGiven.add(map1);
    	listGiven.add(map2);
    	
    	// empMapper가 employeeList()를 호출할 때 listGiven을 return(메서드의 결과를 미리 지정 : Mock)
    	when(empMapper.employeeList()).thenReturn(listGiven);
		
		// when(실행)
    	List<Map<String, Object>> listWhen = empService.getEmployeeList();
    	
    	// then(검증)    	
    	assertThat(listWhen.get(0).get("empId")).isEqualTo("goodee");
    	assertThat(listWhen.get(1).get("empId")).isEqualTo("goodee2");
    	assertThat(listWhen.size()).isEqualTo(2);
    	    	
    	// empService의 getEmployeeList() 메소드가 한 번 호출되었는지 검증
        verify(empService, times(1)).getEmployeeList();
    		
    }
    
    @Test
	@DisplayName("현재 등록된 직원 수") 
	void empCntTest() {

		// given(준비)
    	when(empMapper.employeeCnt()).thenReturn(10);

		// when(실행)
		int empCnt = empService.getEmployeeCnt();

		// then(검증)
		assertThat(empCnt).isEqualTo(10);
	}
        
    @Test
	@DisplayName("특정한 직원의 상세 정보") 
	void empOneTest() {
    	
    	// given(준비)
    	Map<String, Object> mapGiven = new HashMap<>();
    	mapGiven.put("h", "goodee");
    	
    	when(empMapper.employeeOne(any())).thenReturn(mapGiven);
    	
    	// when(실행)
    	Map<String, Object> mapWhen = empService.getEmployeeOne("goodee");
    	
    	// then(검증)
    	assertThat(mapWhen.get("h")).isEqualTo("goodee");
    	
    }
    
    @Test
	@DisplayName("직원이 추가되는지 확인") 
	void insertEmpTest() throws IOException {

		// given(준비)
		Employee e = new Employee();
		e.setBranchNo(1);
		e.setEmployeeId("goodee");
		e.setEmployeePw("1234");
	
		when(empMapper.insertEmployee(e)).thenReturn(1);
		
		EmployeeDetail ed = new EmployeeDetail();
		ed.setEmployeeNo(1);
		ed.setEmployeeName("구디");
		ed.setEmployeePhone("01011111111");
		ed.setEmployeeEmail("goodee@naver.com");
		ed.setEmployeeGender("m");
		
		when(empMapper.insertEmployeeDetail(ed)).thenReturn(1);
			
		String filename = "testFile";
        String contentType = "png";
        String filePath = "src/main/webapp/upload/emp/testFile.png";
		
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + "." + contentType, "image/png", "file content".getBytes());
		
		EmployeeImg ei = new EmployeeImg();
		ei.setEmployeeNo(1);
		ei.setEmployeeImgOriginName("origin.png");
		// ei.setEmployeeImgFilename(filename + "." + contentType);
		ei.setEmployeeImgSize(250);
		ei.setEmployeeImgType("png");
		
		when(empMapper.insertEmployeeImg(ei)).thenReturn(1);

		// when(실행)
		empService.insertEmployee(e, ed, mockMultipartFile, filePath);

		// then(검증)
		verify(empMapper, times(1)).insertEmployee(any(Employee.class));
        verify(empMapper, times(1)).insertEmployeeDetail(any(EmployeeDetail.class));
        verify(empMapper, times(1)).insertEmployeeImg(any(EmployeeImg.class));

	}

}
