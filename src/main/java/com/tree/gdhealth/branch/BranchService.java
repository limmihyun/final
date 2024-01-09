package com.tree.gdhealth.branch;

import com.tree.gdhealth.branch.programcalendar.BranchProgramCalendarService;
import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramCalendar;
import com.tree.gdhealth.sportsequipment.SportEquipmentApiService;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderAddDto;
import com.tree.gdhealth.sportsequipment.dto.getOrderListResponseDto;
import com.tree.gdhealth.employee.api.EmployeeApiService;
import com.tree.gdhealth.employee.login.EmpLoginService;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.vo.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>지점(branch)의 메인 서비스</p>
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchService {
    private final EmpLoginService empLoginService;
    private final EmployeeApiService employeeApiService;
    private final SportEquipmentApiService sportEquipmentApiService;
    private final BranchProgramCalendarService branchProgramCalendarService;

    public LoginEmployee testEmployeeLogin(Employee employee) {
        return empLoginService.login(employee);
    }

    public List<Map<String, Object>> getBranchEmployeeList(Integer branchNo) {
        return employeeApiService.getBranchEmployeeList(branchNo);
    }

    public getOrderListResponseDto getBranchSportsEquipmentOrderList(Integer branchNo, int requestPage, boolean isOnlyWaitingList) {
        return sportEquipmentApiService.getSportsEquipmentOrderList(branchNo, requestPage, isOnlyWaitingList);
    }

    public boolean addBranchEquipmentOrder(SportsEquipmentOrderAddDto dto) {
        return sportEquipmentApiService.addSportsEquipmentOrder(dto);
    }

    public BranchProgramCalendar getBranchProgramCalendar(LocalDate requestDate, Integer branchNo) {
        return branchProgramCalendarService.getBranchProgramCalendar(requestDate, branchNo);
    }
}
