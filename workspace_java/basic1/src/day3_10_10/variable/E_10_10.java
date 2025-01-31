package day3_10_10.variable;
// static이 붙은 메소드 안에서는 static이 없는 변수를 사용할 수 없다.
// 이 말은 static이 없는 메소드 안에서는 사용할 수 있다.
public class E_10_10 {
    // 변수 x는 전역변수 이지만 static가 붙지 않아서 hap메소드 안에서
    // 호출이 가능합니다.
    // 그러나 main메소드 안에서는 호출이 불가 합니다.
    // 왜냐하면 main메소드 앞에는 static이 있으니까
    int x;
    void hap(int i, int j){
        System.out.println(x); // 0
        System.out.println(i + j);
    }
    public static void main(String[] args) {
        E_10_10 e = new E_10_10();
        System.out.println(e.x); // 0
        e.hap(1, 2);
    }
}
