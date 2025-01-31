package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 서블릿 컨테이너가 읽습니다.
public class NoticeServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticeServletApplication.class, args);
	}

}
