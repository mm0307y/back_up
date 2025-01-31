package day5_10_14.variable;

public class Oper2_10_14 {
    public static void main(String[] args) {
        int i = 1;
        // 변수 뒤에 ++가 있으면 먼저 i를 변수 j에 대입하고
        // 그 다음에 증가한다.
        // 변수 앞에 ++(i=i+, i=i-1)가 있으면
        // 먼저 1을 증가시키고 그 다음에 대입하세요.
        System.out.println(i); // 1
        int j = ++i; // j=i, i=i+1, j=2
//        j = ++i;
        System.out.println(i); // 2
        System.out.println(j); // 1
    }
}
