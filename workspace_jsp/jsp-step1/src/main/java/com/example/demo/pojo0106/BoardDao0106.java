package com.example.demo.pojo0106;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardDao0106 {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

  public List<Map<String, Object>> boardList(Map<String, Object> pmap) {
    List<Map<String, Object>> bList = null;

    // 물리적으로 떨어져 있는 서버에 커넥션을 맞는다.
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();

    // 연결이 되고 쿼리문을 요청할 때 필요한 메서드를 제공한다.
    // sqlSession.insert(), sqlSession.update(), sqlSession.delete() 등 제공해주고 있다.
    SqlSession sqlSession = null;

    try {
      sqlSession = sqlSessionFactory.openSession();
      bList = sqlSession.selectList("boardList", pmap);
      log.info(bList);
    } catch (Exception e) {
      log.info(e.toString());
    }
    return bList;
  }

}
/*
 * 조회 결과에 null이 출력되는 경우
 * 1) DB에서 조회한 결과에 대해 return시 null을 입력한 경우
 * 2) DB테이블에 commit()을 하지 않은 경우
 * 3) 조건절에 들어오는 값이 존재하지 않는 값을 파라미터로 넘긴 경우
 */