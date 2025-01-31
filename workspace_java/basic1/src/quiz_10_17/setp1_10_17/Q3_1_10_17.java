package quiz_10_17.setp1_10_17;

public class Q3_1_10_17 {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;

//        if (() && ()){}
        if((++i == j) && (++i < j--)){
            System.out.println("참일 때 : i " + i + ", j : " + j );
        }
        else {
            System.out.println("거짓 일 때 : i " + i + ", j : " + j );
        }
        // insert here -> i는 얼마, j는 얼마인지를 맞춰보세요.
    }
}
