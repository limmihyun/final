package com.tree.gdhealth.branch;

import com.tree.gdhealth.employee.dto.EmployeeInformationDto;
import com.tree.gdhealth.program.dto.BranchProgramCalendar;
import com.tree.gdhealth.program.ProgramApiService;
import com.tree.gdhealth.sportsequipment.SportsEquipmentApiService;
import com.tree.gdhealth.sportsequipment.dto.*;
import com.tree.gdhealth.employee.api.EmployeeApiService;
import com.tree.gdhealth.employee.login.EmpLoginService;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.utils.pagination.PageUri;
import com.tree.gdhealth.utils.pagination.PaginationUriGenerator;
import com.tree.gdhealth.vo.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * <p>branch의 메인 서비스파사드</p>
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchServiceFacade {
    private final EmpLoginService empLoginService;
    private final EmployeeApiService employeeApiService;
    private final SportsEquipmentApiService sportsEquipmentApiService;
    private final ProgramApiService branchProgramCalendarService;
    private final PaginationUriGenerator paginationUriGenerator;

    public LoginEmployee testEmployeeLogin(Employee employee) {
        return empLoginService.login(employee);
    }

    public List<EmployeeInformationDto> getBranchEmployeeList(Integer branchNo) {
        return employeeApiService.getEmployeeListByBranchNo(branchNo);
    }

    public List<SportsEquipmentOrderInformation> getBranchSportsEquipmentOrderList(
            SportsEquipmentOrderRetrieveCriteria criteria) {
        return sportsEquipmentApiService.getSportsEquipmentOrderList(criteria);
    }
    public List<PageUri> getBranchSportsEquipmentOrderListPagination(
            SportsEquipmentOrderRetrieveCriteria criteria,
            String urlPath ) {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
            paramMap.add("requestPage", String.valueOf(criteria.getRequestPage()));
            paramMap.add("isOnlyWaitingList", String.valueOf(criteria.getIsOnlyWaitingList()));
            paramMap.add("branchNo", String.valueOf(criteria.getBranchNo()));
            paramMap.entrySet().removeIf(entry -> entry.getValue().contains("null"));

        int lastPage = sportsEquipmentApiService.getSportsEquipmentOrderListLastPage(criteria);
        return paginationUriGenerator.getPageUriList(criteria.getRequestPage(),lastPage,urlPath,paramMap);
    }

    public boolean addBranchEquipmentOrder(SportsEquipmentOrderAddRequestDto dto) {
        return sportsEquipmentApiService.addSportsEquipmentOrder(dto);
    }

    public BranchProgramCalendar getBranchProgramCalendar(LocalDate requestDate, Integer branchNo) {
        return branchProgramCalendarService.getBranchProgramCalendar(requestDate, branchNo);
    }

    public Object getSportsEquipmentOrderOne(Integer orderNo) {
        return sportsEquipmentApiService.getSportsEquipmentOrderOne(orderNo);
    }

    public boolean changeSportsEquipmentOrderStatus(Integer orderNo, String changeOrderStatus) {
        return sportsEquipmentApiService.changeSportsEquipmentOrderStatus(orderNo, changeOrderStatus);
    }
}
