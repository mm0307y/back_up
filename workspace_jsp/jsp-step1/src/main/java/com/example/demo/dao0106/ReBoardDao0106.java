package com.example.demo.dao0106;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// @Service
@Repository
public class ReBoardDao0106 {
  @Autowired
  private SqlSessionTemplate sqlSessionTemplate = null;

  public List<Map<String, Object>> boardList() {
    List<Map<String, Object>> bList = null;
    sqlSessionTemplate.selectList("boardList", null);
    return bList;
  }

}
