package classes_10_17.ui_10_18.refresh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMain_10_18 extends JFrame implements ActionListener {
    JTextArea jta = new JTextArea();
    JButton refresh = new JButton("Refresh");

    public JFrameMain_10_18() {
        initDisplay();
    }

    public void initDisplay(){
        // 아래 문장이 있어야 actionPerformed 메서드가 호출됩니다.
        refresh.addActionListener(this);
        this.add("Center", jta);
        this.add("South", refresh);
        this.setSize(500,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        /*인스턴스 변수를 선언하지 않고 생성부만 작성하였다.
        왜냐하면 initDisplay() 메서드 호출하려고 인스턴스화를 하는 건데
        생성자 안에서 호출하는 방법으로 진행해 보려고 한다.*/
        new JFrameMain_10_18();
    }

    /*메서드 선언 앞에 @(언오케이션?) Override를 붙인 건 부모클래스나 인터페이스이거나
    또는 추상클래스가 정의한 메소드를 재정의하는 경우에 붙인다.
    이 경우 선언부를 절대로 훼손하며 안된다.*/
    @Override
    public void actionPerformed(ActionEvent e) {
        /*콜백메서드(or main) 내에서는 보통 인스턴스화를 하지 않습니다.
        내가 제어할 수 있는 메서드가 아니라서
        addActionListener 발동 될 때마다 인스턴스화가 계속 일어난다.
        안 괜찮다.*/
//        System.out.println(e.getActionCommand() + ", " + e.getSource());
        Object obj = e.getSource();
        if(obj == refresh){
            System.out.println("refresh 버튼 클릭");

            // 처음에 그려진 화면에서 필요없는 컴포넌트 삭제를 할 때 사용한다.
            Container cont = this.getContentPane();
            if(jta != null){
                cont.remove(jta);
                cont.remove(refresh);
            }

            JPanel1_10_18 jp1 = new JPanel1_10_18();
            this.add("Center", jp1);
            cont.revalidate();
        }
    }
}
