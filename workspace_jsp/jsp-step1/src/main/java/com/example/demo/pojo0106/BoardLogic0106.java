package com.example.demo.pojo0106;

import java.util.ArrayList;
import java.util.HashMap;
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
    log.info("boardDetail 호출");
    List<Map<String, Object>> list = new ArrayList<>();
    list = boardDao.boardList(pmap);
    if (list.size() > 0) { // 조회결과가 존재하니? true
      boardDao.hitCount(pmap);
    }

    // 상세보기 후 상세내용에 대한 댓글 조회하기
    List<Map<String, Object>> coList = boardDao.commentList(pmap);

    // 현재 상세보기(b_no)에 대한 댓글이 존재하니?
    if (coList != null && coList.size() > 0) { // 댓글이 존재하는 경우에 해당
      Map<String, Object> cmap = new HashMap<>();
      cmap.put("COMMENT", coList);
      list.add(cmap); // [{},{}, COMMENT : []{},{}]]
    }
    return list;
  } // end of boardDetail

  public int boardInsert(Map<String, Object> pmap) {
    log.info("boardInsert : " + pmap);
    int result = -1;
    result = boardDao.boardInsert(pmap);
    return result;
  }

  public int boardUpdate(Map<String, Object> pmap) {
    log.info("boardUpdate");
    int result = -1;
    result = boardDao.boardUpdate(pmap);
    return result;
  }

  public int boardDelete(Map<String, Object> pmap) {
    log.info("boardDelete");
    int result = -1;
    result = boardDao.boardDelete(pmap);
    return result;
  }

  public int commentInsert(Map<String, Object> pmap) {
    log.info("commentInsert");
    int result = -1;
    result = boardDao.commentInsert(pmap);
    return result;
  } // end of 댓글 작성하기

  public int commentUpdate(Map<String, Object> pmap) {
    log.info("commentUpdate");
    int result = -1;
    result = boardDao.commentUpdate(pmap);
    return result;
  }
}

/*
 * NullPointerException
 * CastException
 */