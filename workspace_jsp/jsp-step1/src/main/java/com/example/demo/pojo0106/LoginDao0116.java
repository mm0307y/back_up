package com.example.demo.pojo0106;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2 // lombok
public class LoginDao0116 {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

  public Map<String, Object> login(Map<String, Object> pmap) {
    log.info("login called...");

    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    // 연결이 되고 쿼리문을 요청할 때 필요한 메서드를 제공한다.
    // sqlSession.insert(), sqlSession.update(), sqlSession.delete() 등 제공해주고 있다.
    SqlSession sqlSession = null;
    Map<String, Object> rmap = null;

    try {
      sqlSession = sqlSessionFactory.openSession();
      List<Map<String, Object>> bList = sqlSession.selectList("login", pmap);
      log.info(bList);
      if (bList != null && bList.size() > 0) {
        rmap = bList.get(0);
      } else {
        rmap = new HashMap<>();
      }
    } catch (Exception e) {
      log.info(e.toString());
    }
    return rmap;
  }
}
