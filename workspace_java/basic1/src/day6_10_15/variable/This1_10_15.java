package day6_10_15.variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
ActionListener 는 JButton 에 대한 이벤트 처리를 담당하는
추상 메서드를 정의하고 있습니다.
그래서 이벤트를 처리하라면 반드시 actionPerformed 메서드를
구현해주세요.
*/
class This1EventHandler implements ActionListener{
    JButton jbtn = null;
    This1EventHandler(JButton jbtn){
        this.jbtn = jbtn;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
//        Object source = e.getSource();
        JButton source = (JButton) e.getSource();
        System.out.println(command +", " + source); // 로그인
        System.out.println(source == jbtn); // true or false(망했다. - 얕은복사가 아니다.)
    }
}

public class This1_10_15 {
    JFrame frame = new JFrame();
    JButton jbtn = new JButton("로그인");
    This1EventHandler handler = new This1EventHandler(jbtn);

    public void initDisplay(){
        jbtn.addActionListener(handler);
        frame.add("North", jbtn);
        frame.setSize(600,450);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        This1_10_15 t1 = new This1_10_15();
        t1.initDisplay();

    }
}
