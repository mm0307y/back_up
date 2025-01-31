package classes_10_17.day5_10_28;

import model_10_28.vo_10_28.Tomato_Member_10_28;

import java.util.ArrayList;
import java.util.List;

public class ListMain3_10_28 {
    public static void main(String[] args) {
        List<Tomato_Member_10_28> list = new ArrayList<>();
        Tomato_Member_10_28 tomato = new Tomato_Member_10_28();
        tomato.setMem_id("tomato");
        tomato.setMem_pw("123");
        tomato.setMem_nick("토마토");
        tomato.setMem_name("김유신");
        System.out.println(tomato); //여기 주소번지값
        list.add(tomato); //ArrayList에 한건이 저장된다.
        System.out.println(tomato == list.get(0)); //true
        list.add(null); //두 번째 인덱스에는 null이 초기화가 되었다.
        System.out.println(list.size()); //2
        tomato = new Tomato_Member_10_28();
        System.out.println(tomato); //16번과는 다른 주소번지를 갖는다.
        tomato.setMem_id("apple");
        tomato.setMem_pw("123");
        tomato.setMem_nick("사과");
        tomato.setMem_name("강감찬");
        list.add(tomato); //세번째 add를 했으니깐 size()가 3입니다.
        System.out.println(list.size()); //3
        System.out.println(tomato + "," + list.get(2));
        System.out.println(tomato == list.get(1)); //true
        System.out.println(tomato.getMem_id()); //apple
        /*프로젝트 진행시나 서비스 구현시에 멤버변수를 변경하는 것은
        상태값을 변경하는 경우도 많아서 주의해야 합니다.
        클래스의 인스턴스변수로 변수의 값을 직접 변경하는 것은 대체로 피하는 것이 좋다.
        사이드이펙트 발생되는 것을 주의해야 한다.*/
//        System.out.println(tomato.mem_id); //멤버변수에 private을 썼다. - 캡슐화
    }
}
