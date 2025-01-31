package classes_10_17.day2_10_21;

public class Array11 {
    public static void main(String[] args) {
        // new로 배열을 선언하면 아직 초기화가 안된 거라서
        // 디폴트 값을 가진다.
        boolean[] bs = new boolean[3]; // false, false, false
        bs[0] = true; // true, false, false
        //반복되는 코드는 항상 옳지 않다. - 개선할 수 있는 방법이 없나? 고민하기
        //출력하는 문장에서 같은 것. System, out, println, bs, []
        //뭐가 다른지 -> 대괄호 안에 숫자만 달라요 - 반복문(for)
        System.out.println(bs[0]); //true
        System.out.println(bs[1]); //false
        bs[2] = true; //false
        System.out.println(bs[2]); //true
        //for(선언 및 초기화 : 조건식 - 반환 값 : true, false : 증감연산자){}
        //주의사항 : for문 안에서 변수 선언을 한 경우 for문 밖에서 접근불가하다.
        int i;
        //반복문은 항상 무한루프에 대한 방지 코드를 고려 합니다.
        //무한 루프에 빠지면 그 다음 코드는 실행기회를 얻지 못합니다. - 재부팅
        for (i=1;i<3;i++){ // 조건식을 생략할 경우 무한루프에 빠진다.
            System.out.println("for문"); // i는

        }
        System.out.println(i); // i는 3이 출련된다.
    }
}
