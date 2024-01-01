package com.tree.gdhealth.branch.programcalendar;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 정인호
 */
@SpringBootTest
class BranchProgramCalendarServiceTest {
    @Autowired
    BranchProgramCalendarService service;
    @Test
    void 해당_지점의_오늘로부터약일주일사이의_프로그램예약_정보를_정상적으로_매핑시킨다(){
        List<BranchProgramDate> dateList = service.getBranchProgramCalendar(LocalDate.now(), 2).getBranchDateList();
        dateList.forEach(System.out::println);
    }

}