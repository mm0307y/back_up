package quiz_10_17.setp1_10_17;

public class String1_10_25 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); //true
        String s3 = new String("Hello");
        System.out.println(s1 == s3); //false
        System.out.println(s2 == s3); //false
        System.out.println(s1.equals(s3)); //true
        System.out.println(s2.equals(s3)); //true
    }
}
