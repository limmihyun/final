package com.tree.gdhealth.headoffice.customValidation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FutureDateValidator implements ConstraintValidator<FutureDate, List<String>>{

	@Override
	public void initialize(FutureDate constraintAnnotation) {
		// 초기화 로직이 없을 경우 생략
	}
	
	@Override
	public boolean isValid(List<String> values, ConstraintValidatorContext context) {
		
		if (values == null || values.isEmpty()) {
            return false; // 비어있는 값은 유효하지 않다고 간주
        }
		
		try {
			
			for (String value : values) {
				 
				 // String을 파싱하여 LocalDate로 변환
				 LocalDate date = LocalDate.parse(value);
				 
				 // 날짜가 현재 날짜와 같거나 그 이후가 아니면 false 반환
				 if(!(date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now()))) {
					 return false;
				 } 
			}
			
		} catch(DateTimeParseException e) {
			// DateTimeParseException이 발생하면 false 반환
			return false;
		}
		
		// 모든 요소가 현재 날짜와 같거나 그 이후이면 유효하다고 판단하여 true를 반환
		return true;
	}	
}
