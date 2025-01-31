package day7_10_16.variable;

public class N2_10_16 {

    void methodA(){
        System.out.println("this : " + this);
    }

    public static void main(String[] args) {
        
        N2_10_16 n = new N2_10_16();
        System.out.println("n : " + n);
        n = null;
        n = new N2_10_16();
        n.methodA();
    }
}
