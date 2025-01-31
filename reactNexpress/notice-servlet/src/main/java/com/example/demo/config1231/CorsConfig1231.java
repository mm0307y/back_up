package com.example.demo.config1231;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// 호출되는 시점은 Spring 어플리케이션이 시작될 때 클래스를 읽어서 설정을 적용한다.
@Configuration // Spring 설정 클래스로 사용한다.
public class CorsConfig1231 {
  // @Bean : Spring 컨텍스트에 CorsFilter를 등록하기 위해 사용한다.
  // 빈 어노테이션은 스프링이 객체 라이프사이클을 관리해 준다.
  // 스프링도 서블릿과 같은 싱글톤
  // 다른 점은 서블릿은 게으른 객체 주입을 제공하고 스프링은 이른 객체 주입을 제공한다.
  // 게이른은 필요할 때 그 때 객체를 생성 주입하는 방법
  // 이른은 미리 객체를 생성 갖고 있다가 요청이 있을 주입되는 방법
  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();

    config.setAllowCredentials(true); // 인증 정보 허용
    config.addAllowedOrigin("http://localhost:3000"); // 허용할 Origin
    config.addAllowedHeader("*"); // 모든 헤더 허용
    config.addAllowedMethod("*"); // 모든 HTTP 메서드 허용

    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}

/*
 * Spring boot 프로젝트에서는 CORS(Cross-Origin Resource Sharing)를 설정하기 위한
 * 자바 클래스이다.
 */