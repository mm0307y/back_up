package basic_11_07.generic_11_12;

import jdbc_10_24.book_11_04.BookVO_11_04;
//json -> 자바코드로 변경
//자바코드를 json으로 변경, 웹개발, 하이비리드 앱 개발

import java.util.*;

//파이썬 - 리스트, 튜플, 딕셔너리
public class List3_11_12 {
    public static void main(String[] args) {
        List list0 = new ArrayList(); //제네릭을 사용하지 않았다. - Object
        list0.add(true);
        //형전환 연산자를 사용하지 않고서 할 수 있는 방법이 제네릭입니다.
        boolean isOk = (Boolean) list0.get(0);
        System.out.println("제네릭을 사용하지 않은 경우 " + isOk); //true 출력

        List<Boolean> list1 = new ArrayList<>();
        list1.add(true);
        isOk = list1.get(0);
        System.out.println("제네릭을 사용한경우 " + isOk); //true 출력

        List<Object> list2 = new ArrayList<>();
        list2.add(false);
        isOk = (Boolean) list2.get(0); // list1번과 list3번은 처리 방식이 동일하다. 즉 안써야지
        System.out.println("제네릭을 사용했지만 생략한 1번과 동일하다." + isOk); //false 출력

        List<BookVO_11_04> list3 = new ArrayList<>();
        BookVO_11_04 bookVO = new BookVO_11_04();
        list3.add(bookVO);
        BookVO_11_04 rbvo = list3.get(0);
        System.out.println(rbvo + " == " + bookVO);

        List<Map<String, Object>> list4 = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("b_no", 1);
        map1.put("b_name", "책제목1");
        map1.put("b_author", "김춘추");
        list4.add(map1);
        Map<String, Object> map2 = list4.get(0);
        //Set인터페이스가 제공하는 keySet을 사용하면 키값만 빼서 관리해준다.
        Object[] key = map2.keySet().toArray();
        //위 문장을 두개로 나누너 쓰면 아래와 같다.
        //Set<String> set = map2.keySet();
        //key = set.toArray();
        for (int i = 0; i < key.length; i++) {
            //이때 순서를 보장하지 않습니다. 맵은 랜덤으에서 저장된다.
            System.out.println(map2.get(key[i])); //1, 책제목1, 김춘추
        }
        System.out.println("===================================");
        //아래와 같이 하면 순서가 썩이지 않는다. - 이것은 장점인가? 아니다.
        //차례대로 썼잖아. 하지만 큰 의미가 없다.
        System.out.println(map2.get("b_no"));
        System.out.println(map2.get("b_name"));
        System.out.println(map2.get("b_author"));

    }
}
