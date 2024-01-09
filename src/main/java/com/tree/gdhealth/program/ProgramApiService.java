package com.tree.gdhealth.program;

import com.tree.gdhealth.program.dto.BranchProgramCalendar;
import com.tree.gdhealth.program.dto.BranchProgramDate;
import com.tree.gdhealth.holiday.HolidayApi;
import com.tree.gdhealth.holiday.HolidayApiVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProgramApiService {
    private final ProgramApiMapper programApiMapper;
    private final HolidayApi holidayApi;

    public Map<String, Object> getBranchProgramDate(LocalDate date, int branchNo) {
        return programApiMapper.getBranchProgramDate(date, branchNo);
    }
    @Transactional
    public boolean changeManager(int programDateNo, int managerNo) {
        //confirm if exist
        int foundRow = programApiMapper.selectManager(programDateNo, managerNo);
        int result = 0;
        if(foundRow == 1){
            // if is update
            result = programApiMapper.changeManager(programDateNo, managerNo);
        }else {
            // or insert
            result = programApiMapper.insertManager(programDateNo, managerNo);
        }
        return result == 1;
    }

    /** date 리스트에 휴일 API로 가져온 공휴일정보를 매핑하여 반환
     * @param requestDate 기준일
     * @param branchNo
     */
    public BranchProgramCalendar getBranchProgramCalendar(LocalDate requestDate, int branchNo) {
        BranchProgramCalendar calendar = new BranchProgramCalendar();
        List<BranchProgramDate> dateList = programApiMapper.getProgramDateBetween(branchNo, requestDate.minusDays(1));
        List<HolidayApiVo> holidayList = new ArrayList<>();

        /* 오늘날짜 지정*/
        dateList.stream()
                .filter(date -> LocalDate.now().equals(date.getDate()))
                .findFirst()
                .ifPresent(date -> date.setIsToday(true));

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

        /* 지난주, 다음주 날짜를 지정*/
        calendar.setRequestDate(requestDate);
        calendar.setPreviousWeekDate(requestDate.minusWeeks(1));
        calendar.setNextWeekDate(requestDate.plusWeeks(1));
        calendar.setBranchNo(branchNo);
        calendar.setBranchDateList(dateList);

        return calendar;
    }
}
