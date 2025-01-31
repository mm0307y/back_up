package day2_10_08.variable;
// java.lang 패키지만 import문을 생략할 수 있다.
// 나머지 패키지는 import문을 사용합니다.
import javax.swing.JFrame;
// 1단계 - main메소드 안에서만 코딩을 전개하기
// 2단계 - main메소드 안에 코딩을 가급적 줄여 나가보세요.

// java.lang 패키지 안에 있는 클래스는 JVM이 찾을 수 있다.
// 그러나 java.lang이 아닌 패키지에 있는 클래스는 패키지 이름을 추가해 줘야 합니다.

public class JFrame1_10_08 {
    public static void main(String[] args) {
        // 클래스의 구성요소는 변수와 메소드 입니다.
        // 클래스 안에 변수선언과 메소드 선언이 가능합니다.
        // 이미 JVM이 구현해 놓은 많은 클래스가 있어요.
        // 클래스를 호출할 수 있다.
        JFrame jFrame = new JFrame();
        String title = "전자 계산기";
        // 재정의 할 수 있다.
        // 변수 - (조건문과 반목문) -  배열 (같은 타입만 담을 수 있다. - 장애) - List, Map, Set(여러개도 기억하고, 다른 타입도 기억한다.)
        // -> Session, Cookie(웹, 앱, 하이브리드 - 공유, 유지 - 시간 조절이 가능하다. 상태값을 관리해준다.)
        // -> 데이터셋 (json, csv, xml - 공공포털 - EDA기반 데이터 분석)
        // 한 번에 하나만 기억할 수 있다.
        title = "카카오톡"; // 재정의
        jFrame.setTitle(title);
        jFrame.setSize(500, 300);
        jFrame.setVisible(true); // true이면 화면에 보여줘, false이면 메모리에는 로딩되었지만 보여주지마
    }
}
/*
코드의 양을 늘어나더라도 코드의 복잡도는 늘지 않도록 해주세요.
반복되는 코드는 줄여주세요. - 개선해 주세요. 한번만 해주세요.
 */