package com.tree.gdhealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 기능 실행 애노테이션 : 서블릿컴포넌트(필터, 서블릿, 리스너)를 스캔해서 빈으로 등록한다.
@SpringBootApplication // 스프링 부트 실행 애노테이션
public class GdhealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdhealthApplication.class, args);
	}

}
