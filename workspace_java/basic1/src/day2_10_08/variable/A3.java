package day2_10_08.variable;
// 가상 머신이 실행하는 순서대로 클론코딩 해보는 것은 동의합니다.
// 그러나 무작정 1번라인부터 받아쓰기 하듯이 공부하는 것은 비효율적인 것 같아요
public class A3 {
    // 선언부 - 전역 변수 선언
    // 사용자가 정의한 메소드 입니다.
    // 지변은 초기화를 생략할 수 없다. 그럼 언제 초기화가 되는 건가요?
    // 아래 메소드가 호출될 때 그 때 결정 됩니다. -> call by value

    int hap(int i, int j){//파라미터자리에 변수선언이 가능합니다. - 지변이다
        return i+j;
    }
    // 15(main) - 17 - 18 - 10 - 11 - 12 - 17(return 값이 - 디버깅 - 5값 쥠) - 18 - 19 - 20

    public static void main(String[] args) {
        // 인스턴스화 - 클래스가 heap메모리에 로딩됩니다. - 기억
        A3 a3 = new A3();
        int result = a3.hap(2,3); // 메소드 이름 뒤에 세미콜론으로 끝나면 메소드 호출입니다.
        System.out.println(result);
    }
}
