package day4_10_11.variable;
import java.awt.print.PrinterAbortException;

class Param{
    int i; // 0 정수형의 디폴트값은 0이다.
}

public class TestParam_10_11 {
    void effectParam(Param p) {
        p = new Param(); // 주석이면 원본이다. -> 얕은복사
        System.out.println("sub p" + p); // @abcd1234
        p.i = 100; // 원본이 아니라 복사본(깊은복사)이 변경되니까
        System.out.println("sub i는" + p.i); // 100
    }

    public static void main(String[] args) {
        TestParam_10_11 tp = new TestParam_10_11();
        Param p = new Param();
        System.out.println("main i는" + p); // @abcd1234 16진수 주소번지값 가정
//        System.out.println("main p" + p.toString());
        p.i = 500;
        tp.effectParam(p);
        // main 에서 i를 출력하기 전에 effectParam이 먼저 호출 되었다.
        // 그래서 그 안에서 i값을 변경했다. - 파라미터로 넘긴 p를 다시
        // 인스턴스화를 또 했다.(18번에서 이미 했는데)
        System.out.println("main i는" + p.i); // 500
    }
}

/*

main의 i 와 sub i 가 같은 값을 출력하고 있다.
왜냐면 15번 라인에서 사용자 정의 메소드 effectParam()호출 할 때
13번에서 인스터스화가 된 주소번지(원본)를 파라미터로 넘겨주었다.
(참고 : 얕은복사와 깊은복사)
이 예제에서는 main 메소드에서 500이었지만 main에서 출력전에
effectParam()먼저 호출했다.
파라미터로 얕은복사 즉 main에서 생성된 p의 주소번지를 넘겼다.
그 메소드 내부에서 i값을 다시 p.i = 100 으로 변경 하였다.
원본이 바뀌었다.
*/