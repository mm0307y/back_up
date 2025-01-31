package classes_10_17.day3_10_22;
/*변수 scope(범위) 이슈
내가 선언한 위치의 변수가 어디까지 영향을 끼치는가? - 기초아니다.
멤버변수, 전역변수, 지역변수 - 클래스 설계를 한다.(변수설계, 메서드 설계, 생성자설계가 포함 되었다.)
(메서드 설계가 포함되는 건 리턴타입도 변수, 파라미터 자리도 변수)*/
public class For5_10_22 {
    public static void main(String[] args) {
        int i=0;
        for (i=2; i<=10; i=i+2){
            System.out.println(i);
        } ////end of for
        //for문 밖에서도 변수 i에 대해 접근하려면 for문 밖에서 선언 할 것
    } //// end of main
} //// end of class
