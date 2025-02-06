package com.example.demo.model0206;

import lombok.Data;

@Data
public class ReactBoardComment0206 {
  private int bc_no = 0; // 댓글번호
  private String email = null; // 이메일
  private String bc_comment = null; // 댓글 내용
  private String bc_date = null; // 작성일
  private int b_no = 0; // 원글번호
}
