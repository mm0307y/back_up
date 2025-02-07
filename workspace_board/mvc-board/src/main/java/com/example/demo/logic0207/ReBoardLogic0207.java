package com.example.demo.logic0207;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao0207.ReBoardDao0207;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ReBoardLogic0207 {

  @Autowired
  private ReBoardDao0207 reBoardDao = null; // 절대로 new 하면 안된다. - 빈관리를 받지 않는다.

  public List<Map<String, Object>> boardList(Map<String, Object> pmap) {
    log.info("boardList 호출 성공.");
    List<Map<String, Object>> bList = null;
    bList = reBoardDao.boardList(pmap);
    return bList;
  }
}