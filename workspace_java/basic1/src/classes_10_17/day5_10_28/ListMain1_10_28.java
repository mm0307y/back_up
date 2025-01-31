package classes_10_17.day5_10_28;
//변수 - 배열 - 객체배열 - 리스트, 맵 - 세션과 쿠키(상태관리, 시간관리)
//배열에서 3차원 배여을 쓰지 않는 건 공간이면 직관이 떨어진다.
//리스트나 맵 활용해서 대체할 수 있다. ->JSON, UI가 지원하는 DataSet 객체 설계
import java.util.ArrayList;
import java.util.List;

//자바의 자료구조를 지원하는 컬렉션 프레임워크가 있다. -> java.util 이다.
public class ListMain1_10_28 {
    public static void main(String[] args) {
        //인터페이스는 단독으로 인스턴스화 할 수 없다.(반드시 구현체클래스가 필요하다)
//        List list = new List();
        List list2 = new ArrayList(); //제네릭을 표현하지 않는 경우 타입을 맞춰야 한다.(개발자 목)
        // 제네릭을 사용하면 타입을 명시적으로 정해준다. - 타입을 따로 맞추지 않아도 된다.
        List<String> list3 = new ArrayList<>();
        list2.add(0, "사과");
        list2.add("파인애플");
        for (Object str : list2){
            System.out.println((String)str);
        }
        //add메서드는 오버로딩이 적용된 메서드 이다.
        //맨 앞에서 부터 차례대로 채운다.
        list3.add(0, "멍멍");
        list3.add("야옹");
        boolean isOk = list3.add("멍멍");
        if(isOk){
            System.out.println("추가 성공");
        }
        else {
            System.out.println("추가 실패");
        }
        for (String str : list3){
            System.out.println(str);
        }
    }
}
