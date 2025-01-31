package athread_10_21.swing_11_14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaView_11_14 extends JFrame implements ActionListener {
    //선언부 - 멤버영역
    JTextArea jta_display = null;
    JScrollPane jsp_display = null;
    JTextField jtf_msg = new JTextField(30);

    //배경이미지 객체 선언
    Image backimg = null;
    String imgPath = "D:\\Java\\workspace_java\\basic1\\src\\image\\talk\\tiger2";

    //디폴트 생성자 - 생성안에서 메서드 호출하기
    public JTextAreaView_11_14() {
        initDisplay();

    }////end of constructor



    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //메시지 입력 후 엔터 친거야?
        if (obj == jtf_msg) {
            jta_display.append(jtf_msg.getText() + "\n");
            jtf_msg.setText(""); // 입력 후 텍스트 필드 초기
        }
    }

    //화면 그리기
    public void initDisplay() {
        backimg = getToolkit().getImage("D:\\Java\\workspace_java\\basic1\\src\\image\\talk\\" + "tiger2.jpg");

        jta_display = new JTextArea(){
            @Override
            public void paintComponent(Graphics g){
                g.drawImage(backimg, 0, 0, this);
                setOpaque(false); //배경을 투명하게 설정, 아래 소스가 있어야 텍스트 문자열이 이미지 위로 보인다.
                //JScrollPane의 Viewport에서 현재 스크롤 위치를 가져옵니다.
                //이 위치는 Point객체로 저장되며 JTextArea에서 표시되고 잇는 부분의 시작 좌표를 나타낸다.
                //스크롤시 backImg가 Viewport위치에 맞춰 움직이도록 해야 합니다.
                Point p = jsp_display.getViewport().getViewPosition();
                g.drawImage(backimg, p.x, p.y, null);
                super.paintComponent(g);
            }
        };

        jta_display.setLineWrap(true);
        jta_display.setForeground(Color.WHITE); // 텍스트 색상 설정

        jsp_display = new JScrollPane(jta_display);
        jtf_msg.addActionListener(this);

        this.setSize(500, 800);
        this.setLocation(100, 100);
        this.add("South", jtf_msg);
        this.add("Center", jsp_display);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }////end of initDisplay

    //메인 메서드
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true); // 스킨변경.(기본적으로 지원하느 스킨)
        new JTextAreaView_11_14();


    } ////end of main

}/// /end of JTextAreaView_11_14