package talk_10_16.step1;

import javax.swing.*;

public class KiwiTalk_10_15 {
    // 선언부
    String nickName = null;
    JFrame frame = new JFrame();
//    public KiwiTalk_10_15() {}
    // 파라미터가 하나도 없는 빈(디폴트) 생성자
    // 디폴트 생성자는 선언이 안 돼있으면 JVM대신 제공해준다.
    public KiwiTalk_10_15(String nickName){ // nickName = apple
        System.out.println(nickName); // 지역변수 - apple
        this.nickName = nickName; // 입력받은 값이 온다.
        System.out.println(this.nickName); // 멤버변수 - null
    }

    // 화면 처리부
    public void initDisplay(){
//        KiwiTalk_10_15 kt = new KiwiTalk_10_15();
        System.out.println("Kiwi Talk의 initDisplay 호출 성공");
        frame.setTitle(nickName + " 님의 대화창"); // 멤버변수 - kwi
        frame.setSize(700,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 메인메서드는 없어도 괜찮아 - 왜냐면 KiwiLogin에서
    // 로그인 버튼을 누르면 그 때 화면 처리부 메서드 호출한다.
}
