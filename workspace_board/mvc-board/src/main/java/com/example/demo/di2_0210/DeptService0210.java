package com.example.demo.di2_0210;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

//@Service // - DeptCtx.java 가 있어서 사용을 안해도 된다.
@Log4j2
public class DeptService0210 {
  @Autowired
  private DeptDao0210 deptDao = null;

  public List<Map<String, Object>> deptList() {
    log.info("deptList호출 성공");
    List<Map<String, Object>> list = null;
    list = deptDao.deptList();
    return list;
  }
}
