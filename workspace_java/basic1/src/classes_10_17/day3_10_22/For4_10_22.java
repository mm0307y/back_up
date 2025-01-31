package classes_10_17.day3_10_22;
/*반복문 - for문, while문, do..while()
조건문 - if문, switch문(메신저-직관), 삼항 연산자
무한루프 상황을 연출해 보았다.
무한루프를 방어하는 코드를 생각해야 합니다.
디버깅 능력 키워야 한다. - 투자 -> println 하는 것은 디버깅이라고 하지 않는다.*/
public class For4_10_22 {
    public static void main(String[] args) {
        for (;1<3;){ //초기화가 없다, 조건식도 없다, 증감연산자 안보인다.
            System.out.println("Hello World");
            if(1==1){
                System.out.println("if문 호출");
                break;
            }
        } ////end of for
        //왜 아래 문장은 실행기회를 단 한번도 갖지 못 할까? - 무한루프 - break문
        System.out.println("여기");
    } //// end of main
} //// end of class
