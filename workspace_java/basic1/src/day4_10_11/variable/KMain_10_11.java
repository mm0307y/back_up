package day4_10_11.variable;
class K{
    int i;
}
public class KMain_10_11 {
    public static void main(String[] args) {
        K k = new K();
        System.out.println(k.toString()); // @2f4d3709
        k = null;
        System.out.println(k);
        k = new K();
        System.out.println(k.toString()); // @4e50df2e
        // 에러는 두가지가 있는데 컴파일 에러와 런타임  에러?
    }
}
