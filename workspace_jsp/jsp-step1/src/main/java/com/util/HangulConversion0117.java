package com.util;

// Tomcat서버 경우 인코딩 타입이 ISO-8859_1 -> euc-kr(대한민국 표준), utf-8(다국어)
public class HangulConversion0117 {
  // 영어표준문자셋으로 받은 값을 강제로 euc-kr로 컨버전해준다.
  public static String toKor(String en) {
    if (en == null)
      return null;
    try {
      return new String(en.getBytes("8859_1"), "euc-kr");
    } catch (Exception e) {
      return en;
    }
  } //// end of toKor

  public static String toUTF(String en) {
    // 영어표준문자셋으로 받은 값을 강제로 utf-8로 컨버전해준다.
    if (en == null)
      return null;
    try {
      return new String(en.getBytes("8859_1"), "utf-8");
    } catch (Exception e) {
      return en;
    }
  } //// end of toUTF
}
