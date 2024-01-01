package com.tree.gdhealth.branch.programcalendar;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramCalendar;
import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramDate;
import com.tree.gdhealth.utility.ApiRequest.HolidayApi;
import com.tree.gdhealth.utility.ApiRequest.HolidayApiVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> </p>
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchProgramCalendarService {
    private final BranchProgramCalendarMapper mapper;
    private final HolidayApi holidayApi;

    /** date 리스트에 휴일 API로 가져온 공휴일정보를 매핑하여 반환
     * @param now
     * @param branchNo
     * @return
     */
    public BranchProgramCalendar getBranchProgramCalendar(LocalDate now, int branchNo) {
        LocalDate startDate = now.minusDays(1);

        BranchProgramCalendar calendar = new BranchProgramCalendar();
        List<BranchProgramDate> dateList = mapper.getProgramDateBetween(branchNo, startDate);

        List<YearMonth> yearMonths = dateList.stream().map(date -> YearMonth.from(date.getDate())).distinct().toList();
        List<HolidayApiVo> holidayApiVoList = new ArrayList<>();

        yearMonths.forEach(yearMonth -> {
            try {
                holidayApiVoList.addAll(holidayApi.getHolidayList(yearMonth));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        holidayApiVoList.forEach(holidayApiVo -> {
            dateList.stream().filter(date -> date.getDate().equals(holidayApiVo.getLocdate())).findFirst().ifPresent(date -> {
                        date.setDateName(holidayApiVo.getDateName());
                        date.setIsHoliday(holidayApiVo.isHoliday());
                    });
        });

        calendar.setBranchNo(branchNo);
        calendar.setBranchDateList(dateList);

        return calendar;


    }
}
