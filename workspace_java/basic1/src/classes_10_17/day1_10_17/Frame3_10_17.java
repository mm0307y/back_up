package classes_10_17.day1_10_17;
// 대주제 - 인스턴스화 설득
import javax.swing.*;

public class Frame3_10_17 {
    JFrame frame; // 선언과 생성을 분리해 본다.(굳이)
    // 파라미터가 있는 생성자가 하나라도 있으면 디폴트 생성자를 제공하지 않는다.
    public Frame3_10_17(){
        System.out.println("디폴트 생성자 호출");
    }
    
    public Frame3_10_17(String title) {
        frame = new JFrame(title);
        intiDisplay();
    }

    public void intiDisplay(){
        frame.setTitle("Frame3");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame3_10_17 frame = new Frame3_10_17("JFrame3");
    }
}