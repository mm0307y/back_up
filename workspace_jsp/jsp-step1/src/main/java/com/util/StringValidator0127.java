package com.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringValidator0127 {
  public static boolean containsColon(String input) {
    if (input == null)
      return false;
    return input.contains(":");
  } // 처리 결과에 콜론이 포함이 되었는지 유무 체크

  public static boolean isJspExtension(String input) {
    if (input == null)
      return false;
    return input.endsWith(".jsp");
  } // 확장자에 .jjp이 포함이 되었는지 유무 체크

  public static boolean isJsonFormat(String input) {
    if (input == null || input.trim().isEmpty()) {
      return false;
    }
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      JsonNode jsonNode = objectMapper.readTree(input);
      return jsonNode != null; // 유효한 JSON이면 true반환이 된다.
    } catch (Exception e) {
      return false;
    } 
  } // json포맷 유무 체크
}
/*
 * 스프링처럼 문자열에 :(콜론)이 포함되어 있는지 확인
 * 
 * 문자열에 .jsp 확장자를 가지고 있는지 확인
 * 
 * 문자열이 JSON 포맷인지를 확인
 * 
 * 
 */