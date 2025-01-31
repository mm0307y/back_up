package day5_10_14.variable;
// access modifier(수정사) - 접근제한자, 접근제어자
class A_10_14 extends Object{
    public int i; // 전역변수(멤버변수)를 선언하는 자리입니다. 멤버변수을 쓰려면 앞에 public가 붙어야한다.
    public void hap(int i, int j){

    }
    public static void main(String[] args) {
        // non-static 변수 i는 static영역에서 사용이 불가하다.
        // 그래도 하고싶다.
        A_10_14 a = null; // 참조형일 때 사용하는 리터럴이 null입니다.
        System.out.println(a);
        System.out.println(a.toString());
        System.out.println(a.i); // 컴파일타입은 합법이데 런타임시에는 에러 발생한다.
    }
}
