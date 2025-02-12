package com.example.demo.controller0205;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// 8000번 서버와 카카오 서버의 관계
@Log4j2
@RestController
@RequestMapping("/auth/*")
public class KakaoAuthController0212 {
  @GetMapping("kakao/callback")
  public String kakaoCallback(String code, HttpSession session) {
    // 1단계 : 인가코드 확인하기 - 리액트 서버에서 처리하였고 카카오가 8000번에 응답을 보냈다.
    // 테스트 시나리오 - 리액트 화면에서 카카오 로그인 버튼 클릭 -> 카카오 정해준 인가코드를 받아오는 URL이 제공된다.
    log.info("code : " + code);

    // 2단계 - Access Token 요청하기 - 실제로 스프링이 처리하는 구간은 2단계 구간부터 입니다.
    // 우리는 화면이 없는 상태에서 (postman이 없는)post 요청을 해야 한다.
    // POST방식으로 key=value 형태로 데이터를 요청(카카오 쪽으로)
    // Retrofit2 or OkHttp 라이브러리 - 스프링이 제공하지 않는다.
    RestTemplate restTemplate = new RestTemplate();
    // POST방식으로 전송할 때는 header설정이 필요하다.
    // 헤더 정보에 필요한 값을 넣어서 보내려면 헤더객체를 직접 생성해야 한다.
    HttpHeaders headers = new HttpHeaders();

    // 마임타입을 아래와 같이 하면 내가 전송할 데이터가 key와 value 형태라는 걸 알려주는 코드이다.
    headers.add("Content-Type", "application/x-www-form-urlencoded");
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("grant_type", "authorization_code");
    map.add("client_id", "4ea7ace8a82124712ffdfd528e65bcf5");
    map.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
    map.add("code", code);
    // HttpHeader와 HttpBody를 하나의 오브젝트로 담기
    HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(map, headers);

    // Http요청을 POST로 하기 -> 그리고 response객체로 응답을 받아온다.
    ResponseEntity<String> response = restTemplate.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, tokenRequest, String.class);

    String nickname = null;
    return nickname;
  }
}
