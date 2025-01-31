package classes_10_17.day3_10_22;
/*반복문 - for문, while문, do..while()
조건문 - if문, switch문(메신저-직관), 삼항 연산자
무한루프 상황을 연출해 보았다.
무한루프를 방어하는 코드를 생각해야 합니다.*/
public class For3_10_22 {
    public static void main(String[] args) {
        for (;;){ //초기화가 없다, 조건식도 없다, 증감연산자 안보인다.
            System.out.println("Hello World");
            break;
        } ////end of for
        //왜 아래 문장은 실행기회를 단 한번도 갖지 못 할까? - 무한루프 - break문
        System.out.println("여기");
    } //// end of main
} //// end of class
