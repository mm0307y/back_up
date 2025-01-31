package quiz_10_17.setp1_10_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class List1_10_24 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list instanceof ArrayList<String>); //true
        //왜냐면 List는 인터페이스 이다.
        //List는 구현체 클래스를 가지고 있다.
        List<String> list2 = new ArrayList<>();
        System.out.println(list2 instanceof ArrayList<String>);
        System.out.println(list2 instanceof List<String>);

        /*단독으로 인스턴스화가 불가하다.
        인터페이스는 추상메서드만 가지고 있어서 오른쪽에 사용이 불가하다.
        반드시 구현체 클래스가 와야 합니다.
        구현체 클래스가 추상메서드를 구현했기 때문에 올 수 있다.*/
        List<String> list3 = new Vector<>();

    }
}
