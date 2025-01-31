package day6_10_15.variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/*
키위톡 로그인 화면 입니다.
로그인을 먼저 해야 대화를 할 수 있어요.
이벤트 소스를 지원하는 인터페이스 이름이 있다. -> ActionListener
기능을 아직 결정할 수 없어서 즉, 구현하는 것은 어떤 디바이스인가에
따라서 다르게 구현되어야 하니깐 결정할 수 없다.
actionPerformed는 추상메서드로 정의되어 있다. 어디에 ActionListener에
*/
public class KiwiLogin_10_15 implements ActionListener {
    // 선언부
    JFrame frame = new JFrame();
    JTextField jtf_nickName = new JTextField(""); // North
    JButton jbtn_login = new JButton("Login"); // South
    JButton jbtn_join = new JButton("회원가입"); // Center
//    StringBuilder sb = new StringBuilder();
    // 디폴트 생성자는 생략할 수 있지만 굳이 여서는 구현하여
    // 외부에서 initDisplay()을 호출되도록 해 본다.
    // 생성자는 반환타입이 없다. 반환타입이 있다면 메서드이다.
    public KiwiLogin_10_15(){
//        initDisplay();
    }
//    Scanner sc = new Scanner(System.in);

    // 화면 그리기 메서드 선언
    public void initDisplay(){
        // 이벤트 소스 (jbtn_login)와 이벤트 핸들러(ActionListener 구현한) 클래스를 연결해준다.
        jbtn_login.addActionListener(this);
        jtf_nickName.addActionListener(this);
        frame.add("North",jtf_nickName);
        frame.add("Center",jbtn_join);
        frame.add("South",jbtn_login);
        frame.setTitle("키위톡 로그인");
        frame.setSize(300,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 메인 메서드
    public static void main(String[] args) {
        KiwiLogin_10_15 login = new KiwiLogin_10_15();
        login.initDisplay();
    } //// end of main

    /*
    actionPerformed 는 callback 메소드 입니다.
    개발자가 호출하는 메서드가 아닙니다.
    그럼 언제 호출되죠? 이벤트소스가 이벤트 발생을 느끼면 자동으로 호출해준다.
    누가 : JVM, 언제 : 이벤트가 감지 되었을때 개발자를 대신해서 호출한다.
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object source = e.getSource();
//        System.out.printf("%s, %s \n", command, source.toString());

        if("Login".equals(command)){
            System.out.println(source == jbtn_login);
            System.out.println(source.equals(jbtn_login));
//            String nickName = jtf_nickName.getText();
//            KiwiTalk_10_15 kt = new KiwiTalk_10_15(nickName);
//            kt.initDisplay();
//            frame.dispose();
            //frame.setVisible(false);
        } else if (jtf_nickName == source) {
//            System.out.println("사용자가 입력한 닉네임 : " + jtf_nickName.getText());
            String nickName = jtf_nickName.getText();
//            sb.append(nickName);
            jtf_nickName.setText("");
            // 여기서 추가가 돼야 유지가 되지 않을까?
            KiwiTalk_10_15 kt = new KiwiTalk_10_15(nickName);
            kt.initDisplay();
            frame.dispose();

        } else if("회원가입".equals(command)){

        }
//        else if(command.equals("회원가입")){
//
//        }
    }

} //// end of KiwiLogin_10_15
