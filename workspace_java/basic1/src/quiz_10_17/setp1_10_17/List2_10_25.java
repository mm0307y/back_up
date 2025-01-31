package quiz_10_17.setp1_10_17;

import java.util.ArrayList;
import java.util.List;

class A{

}
public class List2_10_25 {
    public static void main(String[] args) {
        List<A> list = new ArrayList<A>();
        System.out.println(list.size()); //0
        A a = new A();
        list.add(a); //1
        a = new A();
        list.add(a); //2
        a = new A();
        list.add(a); //3
        System.out.println(list.size()); //3
        //자료구조에 있는 모두를 다 출력할 때는 개선된 for문을 사용하세요.
        //앞에는 제네릭 타입을 적는다. 뒤에는 자료구조 클래사그 온다.
        for (A a1 : list) { //개선된 for문 지원한다.
            System.out.println(a);
        }
    }
}
