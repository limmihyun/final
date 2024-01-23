package com.tree.gdhealth.utils.holidayapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** api용 vo
 * @author 정인호
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class HolidayApiVo {
	private String dateKind;
	private String dateName;
	private boolean isHoliday;
	private LocalDate locdate;
	private String seq;

	/** responseBody 문자열을 자바 boolean 타입으로 변경
	 */
	public void setIsHoliday(String YorN){
		if(YorN.equals("Y")){
			this.isHoliday = true;
		}
	}

	/**응답 바디의 문자열날짜를 날짜타입으로 파싱
	 */
	public void setLocdate(String yyyymmdd){
		this.locdate = LocalDate.parse(yyyymmdd, DateTimeFormatter.ofPattern("yMMdd"));
	}
}
