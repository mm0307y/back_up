package athread_10_21.setp1_11_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinView_11_11 extends JDialog implements ActionListener {
    TalkDao_11_11 tDao = new TalkDao_11_11();
    //회원가입 버튼 누르기전에 중복검사 받았어??
    //중복이 아니다. - 사용할 수 있어 - true로 변경한다.
    boolean isIdCheck = false;
    JPanel	   jp_join 		  = new JPanel(null); //회원가입 도화지
    JLabel 	   jlb_name 	  = new JLabel("이름");
    JLabel 	   jlb_id 		  = new JLabel("아이디");
    JLabel 	   jlb_pw 		  = new JLabel("비밀번호");
    JLabel 	   jlb_pw2 		  = new JLabel("비밀번호확인");
    JLabel     jlb_birth 	  = new JLabel("생년월일");
    JLabel 	   jlb_phone 	  = new JLabel("전화번호");
    JLabel 	   jlb_nickName	  = new JLabel("닉네임");
    JLabel 	   jlb_idAvble	  = new JLabel("사용가능한 아이디 입니다.");
    JLabel 	   jlb_idNotAvble = new JLabel("중복된 아이디 입니다.");
    JLabel 	   jlb_title 	  = new JLabel("회원가입");//회원가입 , title 라벨
    JTextField jtf_name 	  = new JTextField(); //이름
    JTextField jtf_id 		  = new JTextField(); //아이디
    JTextField jtf_pw 		  = new JTextField(); //비밀번호
    JTextField jtf_pw2 		  = new JTextField(); //비밀번호 확인
    JTextField jtf_birth 	  = new JTextField(); //생년월일
    JTextField jtf_phone	  = new JTextField(); //폰번호
    JTextField jtf_nickName	  = new JTextField(); //닉네임
    JButton    jbtn_idconfirm = new JButton("중복검사"); //로그인 버튼
    JButton    jbtn_join 	  = new JButton("회원가입");//회원가입 버튼
    Font f_join 		  = new Font("맑은 고딕",Font.PLAIN,25);
    Font	   f_label        = new Font("맑은 고딕",Font.PLAIN,12);

    public JoinView_11_11() {
        initDisplay();
    }

    public void initDisplay() {
        jbtn_idconfirm.setFocusPainted(false);
        jbtn_join.addActionListener(this);
        jbtn_idconfirm.addActionListener(this);
        //타이틀 부분
        ImageIcon bookIcon = new ImageIcon("./image/title.png");
        this.setIconImage(bookIcon.getImage());
        this.setTitle("회원가입 - [바나나톡]");
        //정보입력 부분
        jp_join.add(jtf_name);//이름
        jp_join.add(jlb_name);
        jtf_name.setBounds(95, 100, 180, 35);
        jlb_name.setBounds(57,100, 200, 35);
        jlb_name.setFont(f_label);
        jp_join.add(jtf_id);//아이디
        jp_join.add(jlb_id);
        jtf_id.setBounds(95, 145, 180, 35);
        jlb_id.setBounds(45, 145, 200, 35);
        jlb_id.setFont(f_label);
        jp_join.add(jlb_idAvble);//아이디 중복검사 결과
        jlb_idAvble.setVisible(false);
        jp_join.add(jlb_idNotAvble);
        jlb_idAvble.setBounds(95, 180, 180, 35);
        jlb_idNotAvble.setBounds(95, 180, 200, 35);
        jlb_idNotAvble.setVisible(false);
        jp_join.add(jtf_pw);//비밀번호
        jp_join.add(jlb_pw);
        jtf_pw.setBounds(95, 210, 180, 35);
        jlb_pw.setBounds(35, 210, 200, 35);
        jlb_pw.setFont(f_label);
        jp_join.add(jtf_pw2);//비밀번호확인
        jp_join.add(jlb_pw2);
        jtf_pw2.setBounds(95, 255, 180, 35);
        jlb_pw2.setBounds(10, 255, 200, 35);
        jlb_pw2.setFont(f_label);
        jp_join.add(jtf_birth);//생년월일
        jp_join.add(jlb_birth);
        jtf_birth.setBounds(95, 300, 180, 35);
        jlb_birth.setBounds(35, 300, 200, 35);
        jlb_birth.setFont(f_label);
        jp_join.add(jtf_phone);//전화번호
        jp_join.add(jlb_phone);
        jtf_phone.setBounds(95, 345, 180, 35);
        jlb_phone.setBounds(35, 345, 200, 35);
        jlb_phone.setFont(f_label);
        jp_join.add(jtf_nickName);//닉네임
        jp_join.add(jlb_nickName);
        jtf_nickName.setBounds(95, 390, 180, 35);
        jlb_nickName.setBounds(45, 390, 200, 35);

        jbtn_idconfirm.setBorderPainted(false); //아이디 중복검사 버튼 외곽 라인 없애기
        jbtn_idconfirm.setForeground(Color.WHITE); //아이디 중복검사 버튼 텍스트 색깔 (흰색)
        jbtn_idconfirm.setBackground(new Color(64,64,64)); //아이디 중복검사 버튼 색깔 넣기 (갈색)
        jbtn_idconfirm.setBounds(285, 145, 90, 35);
        jbtn_join.setBounds(42, 450, 300, 45);
        jbtn_join.setBackground(new Color(64,64,64));
        jbtn_join.setForeground(Color.white);
        jbtn_join.setBorderPainted(false); // 테두리 없애기
        jbtn_join.setFocusPainted(false); // 포커스 테두리 없애기
        jlb_title.setFont(f_join);//회원가입 라벨 붙이기
        jlb_title.setBounds(20,30,125,45);
        jp_join.add(jlb_title);//회원가입 라벨 왼쪽 상단에 붙이기
        jp_join.add(jbtn_join);//회원가입 버튼
        jp_join.add(jbtn_idconfirm);//아이디 중복검사 버튼
        jp_join.setBackground(new Color(253,220,81)); //도화지 색깔 노란색
        //JDialog, 회원가입 메인창 정의
        this.setContentPane(jp_join);
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);//창 가운데서 띄우기
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //사용자가 입력한 아이디 가져오기
        String user_id = jtf_id.getText();
        //중복검사 버튼을 누른거야?
        if (obj == jbtn_idconfirm) {
            //아이디가 중복일 경우
            //회원가입을 진행할 때 중복검사를 했어?
            if (tDao.memIdCheck(user_id)) { //입력한 아이디가 존재할 때
                jlb_idAvble.setVisible(false);
                jlb_idNotAvble.setVisible(true);
                //아래값은 회원가입 버튼을 눌렀을 때 사용할 값
                //네이버 로그인, 카카오 로그인 시 콜백으로 받아와야 할 값이다.
                isIdCheck = false; //회원가입을 진행하면 안돼
            }
            //중복이 아닐 경우
            else if (!tDao.memIdCheck(user_id)) {
                jlb_idAvble.setVisible(true);
                jlb_idNotAvble.setVisible(false);
                //회원가입 버튼을 눌렀을 때 사용할 값
                isIdCheck = true; //회원가입을 그대로 진행해도 된다.
            }
        }
        //회원가입을 누르기전에 중복검사 한거야? - isIdCheck
        else if (obj == jbtn_join) { //회원가입 버튼을 눌렀을때
            if (isIdCheck == false) {
                JOptionPane.showMessageDialog(this, "아이디 중복검사가 필수 입니다.", "info", JOptionPane.INFORMATION_MESSAGE);
            }else {
                //정상적으로 회원가입 처리하기 tDao.memberInsert(MemberVO pbvo)
                //System.out.println("회원가입 처리 진행합니다.");
                int result = -1;
                result = tDao.memberInsert(jtf_id.getText(), jtf_pw.getText(), jtf_nickName.getText(), jtf_name.getText() ,jtf_birth.getText(), jtf_phone.getText());
                if (result == 1) {
                    JOptionPane.showMessageDialog(this,"가입이 완료되었습니다.", "info", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this, "가입에 실패 하셨습니다.", "info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    public static void main(String[] args) {
        new JoinView_11_11();
    }
}
