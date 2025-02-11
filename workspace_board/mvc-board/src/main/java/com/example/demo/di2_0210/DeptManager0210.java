package com.example.demo.di2_0210;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.log4j.Log4j2;

import java.awt.FlowLayout;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Log4j2
public class DeptManager0210 extends JFrame implements ActionListener {
  private ApplicationContext ctx = null;
  // DeptCtx.java에서 @Configuration @Bean 등록됐다.

  @Autowired
  private DeptController0210 deptController = null;
  JPanel jp_north = new JPanel();
  JButton jbtn_sel = new JButton("조회");
  JButton jbtn_ins = new JButton("입력");
  JButton jbtn_upd = new JButton("수정");
  JButton jbtn_del = new JButton("삭제");

  public void initDisplay() {
    // ApplicationContext 인터페이스 구현체 클래스인 AnnotationConfigApplicationContext의 생성자 파라미터
    // @Configuration이 붙은 클래스를 넘기면 Spring 컨테이너가 해당 객체의 정보를 스캔한다.
    // 이른 객체 주입이 가능하다.
    ctx = new AnnotationConfigApplicationContext(DeptCtx0210.class);
    deptController = ctx.getBean("deptController", DeptController0210.class);

    this.setTitle("부서관리");
    this.setSize(500, 400);
    // 이벤트 소스와 이벤트 핸들러 클래스를 매핑
    // ActionListener의 구현체 클래스 이므로 actionPerformed 오버라이딩 -> 감지 -> 콜백 메서드

    jbtn_sel.addActionListener(this);
    jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
    jp_north.add(jbtn_sel);
    jp_north.add(jbtn_ins);
    jp_north.add(jbtn_upd);
    jp_north.add(jbtn_del);
    this.add("North", jp_north);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_sel) { // 조회 버튼 누른거야
      System.out.println("조회 버튼 호출 성공");

      // NullPointerException이 발생하지 않고 해당 메서드 호출이 잘 된다. -> 컨테이너 빈 등록 -> DeptCtx.java
      // 빈 등록시 사용된 메서드 이름 앞에 set이 붙으면 setter객체 주입법 코드의 필드 이름이 되는 거다.
      List<Map<String, Object>> list = deptController.deptList();
      log.info(list);
    }
  }

  public static void main(String[] args) {
    DeptManager0210 dm = new DeptManager0210();
    dm.initDisplay();
  }
}
