package com.tree.gdhealth.program;

import com.tree.gdhealth.program.dto.BranchProgramCalendar;
import com.tree.gdhealth.program.dto.BranchProgramDate;
import com.tree.gdhealth.utils.holidayapi.HolidayApi;
import com.tree.gdhealth.utils.holidayapi.HolidayApiVo;
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
 * <p>프로그램 도메인 API 서비스</p>
 *
 * @author 정인호
 */

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProgramApiService {
    private final ProgramApiMapper programApiMapper;

    public Map<String, Object> getBranchProgramDate(LocalDate date, int branchNo) {

        return programApiMapper.getBranchProgramDate(date, branchNo);
    }

    @Transactional
    public boolean changeManager(int programDateNo, int managerNo) {
        //confirm whether it exist
        int foundRow = programApiMapper.selectManager(programDateNo, managerNo);
        int result = 0;
        if (foundRow == 1) {
            // updated
            result = programApiMapper.changeManager(programDateNo, managerNo);
        } else {
            // or insert
            result = programApiMapper.insertManager(programDateNo, managerNo);
        }
        return result == 1;
    }

    public List<BranchProgramDate> getBranchProgramDateList(int branchNo, LocalDate requestDate, int minusDays, int plusDays) {

        int totalDays = plusDays + minusDays;

        return programApiMapper.getProgramDateBetween(branchNo, requestDate.minusDays(minusDays), totalDays);
    }

}
