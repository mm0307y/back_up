package com.example.demo.confing0205;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Maven 방식 - 옛날거 - pom.xml - 반복되는 코드, 배보다 배꼽이 더 크다, 좋은점 - 컴파일은 없다.
// Gradle 방식 - 최근 - Kotlin - application.yml, application.properties, build.gradle
// 배포하기 - 빌드방식, 패키지작업, 웹팩, 번들러

@Configuration // 스프링 부트 기동시에 스캔한다.
public class CorsConfigurer0205 implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // 클라이언트측에서 오는 모든 요청에 대해서
    .allowedOrigins("http://localhost:3000") // 허락해 줄 요청 URL
    .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
    .allowedHeaders("*") // 모든 헤더 허용
    .allowCredentials(true) // 쿠키 또는 인증 정보 포함 허용
    .maxAge(3600); // 1시간 동안 캐시에 기억해줄께    
  }
  
}
