package day4_10_11.variable;

public class N_10_11 {

    // 파라미터가 1개이고 타입은 N클래스 타입 입니다.
    void methodA(N_10_11 n){
        System.out.println(n.toString());
    } // end of methodA()

    // 파라미터가 1개이고 타입은 String클래스 타입입니다.
    void methodB(String msg){
        System.out.println(msg.toUpperCase());
    } // end of methodB

    public static void main(String[] args) {
        N_10_11 n = new N_10_11();
        //n.methodA(n);
        String name = null;
        n.methodB("null");
    }// end of main
} // end of N_10_11