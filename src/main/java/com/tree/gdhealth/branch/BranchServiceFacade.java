package com.tree.gdhealth.branch;

import com.tree.gdhealth.employee.dto.EmployeeInformation;
import com.tree.gdhealth.program.dto.BranchProgramCalendar;
import com.tree.gdhealth.program.ProgramApiService;
import com.tree.gdhealth.program.dto.BranchProgramDate;
import com.tree.gdhealth.sportsequipment.SportsEquipmentApiService;
import com.tree.gdhealth.sportsequipment.dto.*;
import com.tree.gdhealth.employee.api.EmployeeApiService;
import com.tree.gdhealth.employee.login.EmpLoginService;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.utils.holidayapi.HolidayApi;
import com.tree.gdhealth.utils.holidayapi.HolidayApiVo;
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
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

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
    private final ProgramApiService programApiService;
    private final PaginationUriGenerator paginationUriGenerator;
    private final HolidayApi holidayApi;

    /* 직원 도메인영역 시작 */
    public LoginEmployee testEmployeeLogin(Employee employee) {

        return empLoginService.login(employee);
    }

    public List<EmployeeInformation> getBranchEmployeeList(Integer branchNo) {

        return employeeApiService.getEmployeeListByBranchNo(branchNo);
    }

    /* 물품 도메인영역 시작 */
    public Object getSportsEquipmentOrderOne(Integer orderNo) {

        return sportsEquipmentApiService.getSportsEquipmentOrderOne(orderNo);
    }

    public List<SportsEquipmentOrderInformation> getSportsEquipmentOrderList(
            SportsEquipmentOrderRetrieveCriteria criteria) {

        return sportsEquipmentApiService.getSportsEquipmentOrderList(criteria);
    }

    /**
     * @apiNote {@link BranchServiceFacade} ::getSportsEquipmentOrderList 와 같은 조건으로 수행해야합니다.
     */
    public List<PageUri> getSportsEquipmentOrderListPagination(
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

    public boolean addSportsEquipmentOrder(SportsEquipmentOrderAddRequest reqDto) {
        return sportsEquipmentApiService.addSportsEquipmentOrder(reqDto);
    }

    public boolean changeSportsEquipmentOrderStatus(Integer orderNo, String changeOrderStatus) {

        return sportsEquipmentApiService.changeSportsEquipmentOrderStatus(orderNo, changeOrderStatus);
    }

    /* 프로그램 도메인영역 시작 */
    /** <p>지점의 프로그램 스케줄이 담긴 캘린더를 생성하는 메소드</p>
     *  date 리스트에 휴일 API로 가져온 공휴일정보를 매핑하여 반환
     * @param requestDate 기준일
     * @param branchNo
     */
    public BranchProgramCalendar getBranchProgramCalendar(Integer branchNo, LocalDate requestDate) {

        List<BranchProgramDate> dateList = programApiService.getBranchProgramDateList(branchNo, requestDate, 1, 6);
        /* 오늘날짜 지정*/
        dateList.stream()
                .filter(date -> LocalDate.now().equals(date.getDate()))
                .findFirst()
                .ifPresent(date -> date.setIsToday(true));

        List<HolidayApiVo> holidayList = new ArrayList<>();
        /*휴일 찾기*/
        dateList.stream()
                .map(date -> YearMonth.from(date.getDate()))
                .distinct()
                .forEach(yearMonth -> {
                    try {
                        holidayList.addAll(holidayApi.getHolidayList(yearMonth));
                    } catch (Exception e) {
                        log.warn("휴일정보를 가져오는 중 문제가 발생하였습니다. 제외하고 계속합니다.", e);
                    }
                });

        /*휴일정보를 매핑*/
        holidayList.forEach(holiday -> {
            dateList.stream()
                    .filter(date -> date.getDate().equals(holiday.getLocdate()))
                    .findFirst()
                    .ifPresent(date -> {
                        date.setDateName(holiday.getDateName());
                        date.setIsHoliday(holiday.isHoliday());
                    });
        });

        /* 캘린더 객체 정리*/
        BranchProgramCalendar calendar = new BranchProgramCalendar();
        calendar.setRequestDate(requestDate);
        calendar.setPreviousWeekDate(requestDate.minusWeeks(1));
        calendar.setNextWeekDate(requestDate.plusWeeks(1));
        calendar.setBranchNo(branchNo);
        calendar.setProgramDateList(dateList);

        return calendar;
    }
}
