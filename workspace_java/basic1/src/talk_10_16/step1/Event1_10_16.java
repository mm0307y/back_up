package talk_10_16.step1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event1_10_16 extends JFrame implements ActionListener {
    JPanel jp_south = new JPanel(); // Center -> jtf_msg, Eat -> jbtn_send
    JTextArea jta_msg = new JTextArea();
    JScrollPane jsp_msg = new JScrollPane(jta_msg,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JTextField jtf_msg = new JTextField("", 20);
    JButton jbtn_send = new JButton("send");
    JButton jbtn_exit = new JButton("exit");

    public void initDisplay() { // 사용자가 정한 메서드 이름이다.
/*      Event1 클래스가 JFrame을 상속 받았지만 여전히 this는
        자기 자신을 참조하는 수정자(modifier) 이므로 Event1타입이다.
        actionPerformed메소드가 호출되게 하려면
        addActionListener()호출하세요.

        이벤트가 한 번에 두 번씩 호출되고 있다면 아래 문장이 여기저기에 여러번
        호출되지 않았는지 확인해 봐야 한다.*/

        jp_south.setLayout(new BorderLayout());
        jp_south.add("Center", jtf_msg);
        jp_south.add("East", jbtn_send);
        jbtn_exit.addActionListener(this);
        jbtn_send.addActionListener(this);
        jbtn_exit.setBackground(new Color(158, 9, 9));
        jbtn_exit.setForeground(new Color(212,212,212));

        //오늘 뭐해? 엔터 쳤을 때 콜백메소드 호출(actionPerformed)
        jtf_msg.addActionListener(this);
        jbtn_send.setBackground(new Color(19, 99, 57));
        jbtn_send.setForeground(new Color(212,212,212));
        this.add("North", jbtn_exit);
        jta_msg.setBackground(new Color(234, 226, 195));
        this.add("Center", jta_msg);
        this.add("South", jp_south);
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        Event1_10_16 e1 = new Event1_10_16();
        e1.initDisplay();
    }
    // 콜백 메서드 이다. - 왜냐면 개발자가 직접 호출하지 않고
    // 어떤 상환에 놓이면 그 때 JVM이 호출합니다.
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed 호출 성공");
        Object obj = e.getSource();
        // JTextFiel에서 엔터 친거야? 또는 send버튼 누른거야?
        if(obj == jtf_msg || obj == jbtn_send) {
            String msg = jtf_msg.getText();
            jta_msg.append(msg + "\n");
            jtf_msg.setText(""); // 이미 쓴글은 지우기
            jtf_msg.requestFocus();
        }
        else if(obj == jbtn_exit) {
            // 자바 가상머신과 연결된 연결고리를 끊어버린다. 종료
            System.exit(0);
        }
    }
}
