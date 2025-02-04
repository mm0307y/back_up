package com.example.demo.pojo0106;

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
    log.info("boardList 또는 boardDetail 호출 ");
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

  public int boardInsert(Map<String, Object> pmap) {
    log.info("boardInsert");
    int result = -1;

    // MyBatisCommonFactory 초기화 -> SqlSessionFactory 생성하기
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();

    // 쿼리문 처리 요청 및 커밋과 롤백 지원
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      result = sqlSession.insert("boardInsert", pmap);
      log.info(result);
      // 자동 커밋이 꺼짐 상태이므로 따로 호출하지 않으면 반영이 안됩니다.
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return result;
  } // end of boardInsert

  public int boardUpdate(Map<String, Object> pmap) {
    int result = -1;
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;

    try {
      sqlSession = sqlSessionFactory.openSession();
      result = sqlSession.update("boardUpdate", pmap);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return result;
  } // end of boardUpdate

  // 조회수 업데이트 처리
  public void hitCount(Map<String, Object> pmap) {
    log.info("hitCount");
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      sqlSession.update("hitCount", pmap);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close(); // 사용한 자원은 명시적으로 닫아주기
    }
  } // end of hitCount

  public int boardDelete(Map<String, Object> pmap) {
    log.info("boardDelete");
    int result = -1;
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      result = sqlSession.insert("boardDelete", pmap);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return result;
  }

  public List<Map<String, Object>> commentList(Map<String, Object> pmap) {
    log.info("commentList");
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    List<Map<String, Object>> cList = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      cList = sqlSession.selectList("commentList", pmap);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cList;
  }

  public int commentInsert(Map<String, Object> pmap) {
    int result = -1;
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      result = sqlSession.insert("commentInsert", pmap);
      log.info(result);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return result;
  }

  public int commentUpdate(Map<String, Object> pmap) {
    int result = -1;
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      result = sqlSession.update("commentUpdate", pmap);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return result;
  }
} // end of commentList - 댓글 목록 가져오기

/*
 * 조회 결과에 null이 출력되는 경우
 * 1) DB에서 조회한 결과에 대해 return시 null을 입력한 경우
 * 2) DB테이블에 commit()을 하지 않은 경우
 * 3) 조건절에 들어오는 값이 존재하지 않는 값을 파라미터로 넘긴 경우
 */