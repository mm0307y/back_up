package com.example.demo.logic0106;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao0106.ReBoardDao0106;

@Service
public class ReBoardLogice0106 {
  @Autowired
  private ReBoardDao0106 reboardDao = null;
  public List<Map<String, Object>> boardList() {
    List<Map<String, Object>> bList = null;
    bList = reboardDao.boardList();
    return bList;
  }
}
