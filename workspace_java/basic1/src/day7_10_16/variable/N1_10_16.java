package day7_10_16.variable;

public class N1_10_16 {
    void methodA(){
        System.out.println("this : " + this);
    }

    public static void main(String[] args) {
        N1_10_16 n1 = new N1_10_16();
        System.out.println("n1 : " + n1);
        n1.methodA();
    }
}
