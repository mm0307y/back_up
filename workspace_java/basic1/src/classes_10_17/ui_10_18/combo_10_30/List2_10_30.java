package classes_10_17.ui_10_18.combo_10_30;

import java.util.Vector;

class A{

}
public class List2_10_30 {
    public static void main(String[] args) {
        Vector<A> v = new Vector<>();
        v.add(new A());
        v.add(new A());
        v.add(new A());
        for (A a:v){ //개선된 for문
            System.out.println(a);
        }
        A a = v.get(0);
        //17번 a는 candidate 상태로 빠진다. - 쓰레기 값이다. - garvage collector
//        System.gc(); // candidate 상태에 있는 값들을 회수해 주세요. 명시적으로 호출한다.
        a = new A(); //17번에서 참조하던 객체와 연결고리르 끊고 새로운 객체를 참조했다.
        A a1 = v.get(1);
        A a2 = v.get(2);
        System.out.println(a == v.get(0)); //true
        System.out.println(a1 == v.get(1)); //true
        System.out.println(a2 == v.get(2)); //true
    }
}
