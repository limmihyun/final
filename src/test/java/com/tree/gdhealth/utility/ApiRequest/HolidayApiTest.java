package com.tree.gdhealth.utility.ApiRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**<p>api테스트용</p>
 * @author 정인호
 */

@SpringBootTest
class HolidayApiTest {
    @Autowired
    private HolidayApi holidayApi;

    @Test
    void getHolidayList() throws IOException {
        //given
        String yearMonthMay = "2023-05";
        YearMonth yearMonth = YearMonth.parse(yearMonthMay);
        //when
        List<HolidayApiVo> holidayList = holidayApi.getHolidayList(yearMonth);
        //then
        assertThat(holidayList.size()).isEqualTo(3);
    }
}