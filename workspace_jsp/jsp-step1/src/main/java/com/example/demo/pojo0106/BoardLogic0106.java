package com.example.demo.pojo0106;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardLogic0106 {
  BoardDao0106 boardDao = new BoardDao0106();

  public List<Map<String, Object>> boardList(Map<String, Object> pmap) {
    log.info("boardList");
    List<Map<String, Object>> list = new ArrayList<>();
    list = boardDao.boardList(pmap);
    log.info(list.size()); // 0이면 조회결과가 없다.
    return list;
  } //// end of boardList

  public List<Map<String, Object>> boardDetail(Map<String, Object> pmap) {
    List<Map<String, Object>> list = new ArrayList<>();
    list = boardDao.boardList(pmap);
    return list;
  }
}

/*
 * NullPointerException
 * CastException
 */