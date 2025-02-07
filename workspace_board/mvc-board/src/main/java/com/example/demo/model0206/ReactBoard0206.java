package com.example.demo.model0206;

import lombok.Data;

@Data
public class ReactBoard0206 {
  private int b_no = 0; // 글 번호
  private String b_title = ""; // 글 제목
  private String email = null; // 이메일
  private String b_content = null; // 글 내용
  private int b_hit = 0; // 조회수
  private String b_date = null; // 작성일
  private String b_file = null; // 첨부파일
}
