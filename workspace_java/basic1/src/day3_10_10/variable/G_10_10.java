package day3_10_10.variable;

public class G_10_10 {

    public static void main(String[] args) {
        int i = 1;
//        String s = 1;
        String s1 = "1";
        String s2 = "";
        String s3 = "1";
        System.out.println(s1 + s3); // 11
        System.out.println(i + i);
        System.out.println(i + i + "3");
        // integer는 원시형 int의 클래스 이름입니다. - Wrapper class
        System.out.println(i + i + Integer.parseInt("3")); // 5
        System.out.println(i + "3" + i);
        System.out.println(i + "3" + i + 2);
        System.out.println(i + "3" + (i + 2));
    }
}
