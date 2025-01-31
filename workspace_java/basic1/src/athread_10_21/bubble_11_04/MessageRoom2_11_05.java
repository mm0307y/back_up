package athread_10_21.bubble_11_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageRoom2_11_05 extends JFrame implements ActionListener {
    JPanel jp_center = new JPanel(); //색상, 정렬, 버튼, JLabel
    JScrollPane jsp_center = new JScrollPane(jp_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_south = new JPanel();
    JTextField jtf_msg = new JTextField(20);
    JButton jb_msg = new JButton("send");
    //홀수이면 초록, 짝수이면 오렌지
    int i = 1; //멤버변수

    public MessageRoom2_11_05() {
        initDisplay();
    } ////end of MessageRoom

    public void initDisplay(){
        jtf_msg.addActionListener(this);
        jb_msg.addActionListener(this);

        jp_center.setLayout(new GridLayout(0,1));
        jp_south.setLayout(new BorderLayout());
        jp_south.add("Center", jtf_msg);
        jp_south.add("East", jb_msg);
        this.add("Center", jsp_center);
        this.add("South", jp_south);
        this.setSize(400,700);
        this.setVisible(true);
    } ////end of initDisplay

    public static void main(String[] args) {
        new MessageRoom2_11_05();
    } ////end of main

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == jb_msg || obj == jtf_msg) {
            JPanel jp_msg1 = new ChatRight1_11_05("kiwi");
            JPanel jp_msg2 = new ChatLeft1_11_05();
            if (i%2 ==1){
                jp_center.add(jp_msg1);
                i++;
            }
            else {
                jp_center.add(jp_msg2);
                i++;
            }
            jp_center.revalidate();
            jp_center.repaint();
            jtf_msg.setText("");
            //스크롤바 아래로 자동이동
            SwingUtilities.invokeLater(() -> jsp_center.getVerticalScrollBar().setValue(jsp_center.getVerticalScrollBar().getMaximum()));
        } ////end of if(JTextField에 엔터 치거나 전송 버튼 누르면)

    }
} ////end of MessageRoom_11_04
