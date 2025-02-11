package com.example.demo.di2_0210;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2 // AOP
@Component
public class DeptController0210 {
  @Autowired
  private DeptService0210 deptService = null;

  public List<Map<String, Object>> deptList() {
    log.info("deptList호출 성공");
    List<Map<String, Object>> list = null;
    list = deptService.deptList();
    return list;
  }
}
