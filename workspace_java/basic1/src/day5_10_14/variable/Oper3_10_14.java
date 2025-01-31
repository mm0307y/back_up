package day5_10_14.variable;

public class Oper3_10_14 {
    public static void main(String[] args) {
        int x = 2; // x = 2
//        int y = --x; // --가 앞에 있으니까 변수 y에 대입하기 전에 먼저 1을 뺀다.
        int y = x--; // --가 뒤에 있으니까 변수 y에 먼저 대입하고 다음에 1을 밴다.
//        y = x--;
        System.out.println(x); // 1
        System.out.println(y); // 2
    }
}
