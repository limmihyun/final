package com.tree.gdhealth.utility.ApiRequest;

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

	public void setIsHoliday(String YorN){
		if(YorN.equals("Y")){
			this.isHoliday = true;
		}
	}
	public void setLocdate(String yyyymmdd){
		this.locdate = LocalDate.parse(yyyymmdd, DateTimeFormatter.ofPattern("yMMdd"));
	}
}
