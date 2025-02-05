package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//1. 원격 프로그램으로 등록
//@Controller // - jsp, html 응답 나갈 때
@RestController //- json포맷 응답 내보낼때
public class HomeController0203 {
    //2. URL과 메소드 연결
    //http://localhost:8000/home
    //http프로토콜은 텍스트 프로토콜
    //DNS - 도메인 IP 주소 조회
    //브라우저와 톰캣 간의 TCP/IP 연결 - 스트림 생성(단방향 - FIFO)
    //클라이언트측-> 서버측, 서버측 -> 클라이언트측, 2-way, SYN, ACK -> 3-way
    //요청하는 쪽에서 out을 하면 서버측에서 in을 한다.
    //클라이언트 출력이 서버측에서는 입력으로 들어간다.
    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
