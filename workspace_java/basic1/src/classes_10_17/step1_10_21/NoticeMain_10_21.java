package classes_10_17.step1_10_21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeMain_10_21 extends JFrame implements ActionListener {
    //선언부 - 인스턴스화, this(NoticeMain과 JFrame도 포함된다.) 사용
    NoticeDialog_10_21 nd = new NoticeDialog_10_21();

    /*생성자 - 이 클래스에 main()있고 멤버에서 NoticeDialog 인스턴스화 하므로
    NoticeDialog()생성자가 활용된다.
    NoticeMain에서 NoticeDialog클래스를 인스턴스화를 하기 때문이다.
    양쪽 클래스가 모두가 서로를 필요로 하더라도 순환구조가 아닌 한쪽에서만
    인스턴스활르 하고 생성자파라미터에 NoticeMain을 넣어서 원본이
    전달되도록 한다.
    NoticeDialog에서는 절대로 null로 초기화 한뒹 생성자의 파라미터(this로 넘어온)로
    받은 원본을 초기화하여서 사용해야 한다.(원본 컨트롤 한다.)*/
    public NoticeMain_10_21() {

    }

    //화면처리 구현
    public void initDisplay(){ //웹어플리케이션이라면 html,ReactJS, Veu.js, Angular.js
        this.setSize(500,500); //브라우저 인터프리터역할(JVM)
        this.setVisible(true);
    }

    //
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
