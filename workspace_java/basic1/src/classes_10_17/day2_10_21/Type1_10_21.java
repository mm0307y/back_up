package classes_10_17.day2_10_21;
/*자료구조를 사용하는 경우 모두 Object단위로 일고 쓸 수 있다.
그래서 타입을 맞춰야 한다.
이 문제를 개선하기 위해서 제네릭이나 형전환이 필요하다.*/


public class Type1_10_21 {
    public static void main(String[] args) {
        String msg = "오늘 스터디 할까?";
        Object obj = msg;
//        String temp = new Object();
        Object obj1 = new String();
        Object obj2 = null;
        obj2 = msg;
        String msg2 = (String)obj2;
        System.out.println(msg2);
        // 메신저 프로젝트 - 문자열 처리와 관련된 API활용 합니다.
    }
}
