package quiz_10_17.setp1_10_17;

import java.util.ArrayList;
import java.util.List;

public class Test2_10_25 {
    int x = 1;
    public static void main(String[] args) {
        List<Test2_10_25> list = new ArrayList<Test2_10_25>();
        System.out.println(list.size());

        Test2_10_25 t2 = new Test2_10_25();
        t2.x = 10;
        System.out.println("주조번지 확인 : " + t2); //여기 주소번지와 16번
        list.add(t2); //여기 주소번지와 17(리스트안에 담는다.)

        t2 = new Test2_10_25();
        t2.x = 20;
        list.add(t2); //여기 주소번지가 다르다. (리스트안에 담는다. 2개째)
        System.out.println("리스트안에 있는 t2 주소번지 확인 : " + list.get(0)); //여기 주소번지가 같다.
        System.out.println(list.size()); //2
        System.out.println(t2 == list.get(1));
        System.out.println(list.get(0).x == list.get(1).x); //false
    }
}
