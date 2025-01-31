package talk_10_16.step1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// BorderLayout1은 이벤트 처리를 담당하는 클래스의 역할을 같이하고 있다.
// 여기서는 일부러 분리하여 처리해 본다. - this 대신에 인스턴스 변수를 쓴다.
// this를 쓸 때와 인스턴스 변수를 쓸 때를 보여주는 거니까 구분할 수 있다.
class BorderLayout2Event implements ActionListener {
    /* BorderLayout1.java 에서는 이벤트 처리르 담당할 클래스를
    나누지 안혹 직접 하나의 클래스에 구현하였다.
    actionPerformed라는 메소드를 구현하고 있는 클래스를
    이벤트핸들러 클래스라고 부른다.
    코드 블록에서 한 부분을 변경했을 때 이와 관련된 변수가
    사용되는 부분을 모두 변경해야 합니다. */

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed 호출 성공");
        Object obj = e.getSource(); // jbtn_north, jbtn_south, jbtn_west, jbtn_east, jbtn_center
        JButton btn = (JButton)obj;
        // instanceof 예약어는 타입을 확인하는 키워드입니다.

        if(obj instanceof JButton){
            System.out.println("너는 JButton타입 입니다.");
        }
    }
}

public class BorderLayout2_10_16 {
    BorderLayout2Event bl = new BorderLayout2Event();
    JButton jbtn_north = new JButton("North");
    JButton jbtn_south = new JButton("South");
    JButton jbtn_west = new JButton("West");
    JButton jbtn_east = new JButton("East");
    JButton jbtn_center = new JButton("Center");
    JFrame frame = new JFrame();
    JPanel jp = new JPanel();
    // 화면을 그리는 메소드 선언하기
    // 메소드 중심의 코딩을 전개하는 연습하기

    public void initDisplay(){
        // JPanel 속지는 디폴ㄷ트가 FlowLayout 이라서
        // 화면 왼쪽에서 부터 오른쪽으로 차례대로 배치된다.
        // setLayout 메소드를 활용해서 강제로 BorderLayout으로 설정한다.
        jp.setLayout(new BorderLayout());
        // 왜 디스를 사용할 수 없나요. - actionPerformed 재정의 안해서 사용할 수 없다.
        jbtn_north.addActionListener(bl);
        jbtn_south.addActionListener(bl);
        jbtn_west.addActionListener(bl);
        jbtn_east.addActionListener(bl);
        jbtn_center.addActionListener(bl);
        System.out.println("initDisplay 호출 성공");
        jp.setBackground(new Color(8,40,196));
        jp.add("North", jbtn_north);
        jp.add("South", jbtn_south);
        jp.add("West", jbtn_west);
        jp.add("East", jbtn_east);
        jp.add("Center", jbtn_center);
        frame.add("Center", jp);
        // JFrame을 상속받아서 JFrame을 따로 인스턴스화를 하지 않아도 된다.
        // 코드 한줄이 줄었다.
        frame.setSize(400,300);
        frame.setVisible(true);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        BorderLayout2_10_16 bl = new BorderLayout2_10_16();
        bl.initDisplay();
    }
}
