package com.tree.gdhealth.utils.holidayapi;


import java.io.IOException;
import java.time.YearMonth;
import java.util.List;
/** 공공데이터, 휴일정보를 가져오는 api의 인터페이스
 * @author 정인호
 */
public interface HolidayApi {

    List<HolidayApiVo> getHolidayList(YearMonth yearMonth) throws IOException;
}
