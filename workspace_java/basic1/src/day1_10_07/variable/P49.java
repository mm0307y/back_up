package day1_10_07.variable;

public class P49 {
    //사용자 정의 메소드입니다.
    //사용자 정의 메소드를 호출하면 파라미터 자리의 지변에 초기화 일어납니다.
    //int타입도 원시형 타입 입니다. 원시형 타입은 호출하면 값이 나옵니다.
    //파라미터 자리의 지변은 hap메소드가 호출될 때 초기화가 일어납니다.

    static int hap(int i, int j)
    {//i=1, j=2초기화됨
        return i+j;//1+2 즉 3을 반환합니다.
    }

    public static void main(String[] args) {
        System.out.println(hap(1,2));//3이 출력됩니다. 왜냐면 반환값이 존재하니까
        int result = hap(1,2);
        System.out.println(result);// 3이 출력됩니다.
        String a = "아이패드에";
        //변수는 한 번에 하나만 기억할 수 있다.
        a = "갤럭시탭";//변수 선언시 아이패드에로 초기화된 것이 갤럭시탭으로 재정의 되었다.
        String b = "출력";
        System.out.println("변수를 사용하지 않고: 화면출력");//변수를 사용해서 처리해 봅니다
        System.out.println("변수를 사용하지 않고: 화면출력");//변수를 사용해서 처리해 봅니다
        //변수 a의 초기화를 바꾸었더니 출력결과가 모두 바뀌었다.
        System.out.println("변수를 사용해서 출력함: "+a+" "+b);//띄어쓰기 없이 화면출력
        System.out.println("변수를 사용해서 출력함: "+a+" "+b);//띄어쓰기 없이 화면출력
        System.out.println("변수를 사용해서 출력함: "+a+" "+b);//띄어쓰기 없이 화면출력
        //print()있으니까 메소드 입니다.
        //그런데 맨 뒤에 세미콜론으로 끝났으므로 메소드 호출입니다.(메소드 구현이 아닙니다.)
        System.out.print("hello");
        System.out.print(10);
    }
}
