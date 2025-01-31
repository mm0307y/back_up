package day2_10_08.variable;

public class A4
{
    // 선언부
    // 여기서 선언하면 전역변수 입니다.
    int i; // 전역변수

    // 사용자 정의 메소드 선언하기


    // main 메소드가 가장 먼저(순서) 실행됩니다.
    // main 메소드가 있으면 exe파일을 만들수 있다. - 실행할 수 있다.
    public static void main(String[] args)
    {
        // 이 안에서 선언하는 변수는 모두 지역변수 입니다.
        int i; // 지역변수
        // println 괄호안에 사용되는 변수 i는 호출입니다.
        // 왜?
        // 선언한 후에 초기화를 두 줄로 나누어 할 수 있으니까 에러가 발생하지 않았다.
        // 변수이름 앞에 int타입을 적으면 변수 선언입니다.
        // 같은 이름의 변수를 두번 선언할 수 없습니다.
        // 단 예외가 있는데 전역변수는 가능합니다.
        i = 1;
        System.out.println(i); // 호출은 사용하기 입니다.

        // 질문 : 전역변수도 출력해 보고 싶어요. 어떻하지?
        A4 a4 = new A4();
        a4.i = 1;
        System.out.println(a4.i);

        A4 Z = new A4();
        System.out.println(Z.i);

    }///////// end of main
}///////////// end of A4
