package classes_10_17.day1_10_17;
// 대주제 - 인스턴스화 설득
import javax.swing.*;
// 여러개의 생성자가 있을 때 각각의 생성자 호출 해보기
public class Frame2_10_17 {
    JFrame frame; // 선언과 생성을 분리해 본다.(굳이)
    /* 디폴트 생성자는 없을 경우 JVM이 대신 주입을 해준다.
    그러나 파라미터가 있는 생성자가 하나라도 있으면 제공되지 않는다.*/
    public Frame2_10_17() { // 디폴트(파라미터가 없는) 생성자다.
        /* setTitle메서드가 아니어도 생성자로 초기화를 할 수있다.
        같은 이름의 생성자를 여러개 가질 수 있다.(오버로딩이다.)
        오버로딩 - 파라미터의 갯수가 다르거나 또는 타입이 다르면 다른 생성자로 인지한다.*/
        frame = new JFrame("JFrame2");
        intiDisplay();
    }

    public Frame2_10_17(String title) {
        // 생성자 호출시 파라미터로 복사된 문자열이 생성자 호출할 때 전달 된다.
        frame = new JFrame(title);
        intiDisplay();
    }

    public void intiDisplay(){
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame2_10_17 f2 = new Frame2_10_17();
        Frame2_10_17 f22 = new Frame2_10_17("JFrame22");
    }
}