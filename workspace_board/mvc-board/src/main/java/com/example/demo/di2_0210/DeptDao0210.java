package com.example.demo.di2_0210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository // - JPA 사용시에도 동일하게 사용을 안해도 된다.
public class DeptDao0210 {
  // 주의 : Autowired 파라미터를 생략하면 required옵션이 @RequestParam처럼 true이다.
  // 필수로 객체 주입이 되어야 하는 경우이다. - null이니까 에러가 발생한다.
  @Autowired(required = false)
  private SqlSessionTemplate sqlSessionTemplate = null;

  public List<Map<String, Object>> deptList() {
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> rmap = new HashMap<>();
    rmap.put("dname", "개발부");
    rmap.put("loc", "부산");
    list.add(rmap);
    rmap = new HashMap<>();
    rmap.put("dname", "운영부");
    rmap.put("loc", "대전");
    list.add(rmap);
    return list;
  }
}
