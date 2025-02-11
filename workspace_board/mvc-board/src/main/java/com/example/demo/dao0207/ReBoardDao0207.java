package com.example.demo.dao0207;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model0206.ReactBoard0206;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class ReBoardDao0207 {

  @Autowired
  private SqlSessionTemplate sessionTemplate = null;

  public List<Map<String, Object>> boardList(Map<String, Object> pmap) {
    log.info("boardList 호출");

    // gubun은 검색조건의 컬럼명 - b_title, b_content, mem_nickname
    log.info(pmap.get("gubun") + ", " + pmap.get("keyword"));
    List<Map<String, Object>> bList = null;
    bList = sessionTemplate.selectList("boardList", pmap);
    return bList;
  }

  public int boardInsert(ReactBoard0206 board) {
    log.info("boardInsert 호츌");
    int result = -1;
    result = sessionTemplate.insert("boardInsert", board);
    return result;
  }

  public void hitCount(Map<String, Object> pmap) {
    log.info("hitCount호출 성공");
    sessionTemplate.update("hitCount", pmap);
  } // end of hitCount

  public List<Map<String, Object>> commentList(Map<String, Object> pmap) {
    log.info("commentList호출 성공");
    List<Map<String, Object>> commList = null;
    commList = sessionTemplate.selectList("commentList", pmap);
    log.info(commList);
    return commList;
  }
  
}