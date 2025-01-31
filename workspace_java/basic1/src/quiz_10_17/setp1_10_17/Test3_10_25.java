package quiz_10_17.setp1_10_17;

public class Test3_10_25 {
    public static void main(String[] args) {
        Test3_10_25[] t3 = new Test3_10_25[3];
        System.out.println(t3.length);//3
        System.out.println(t3);
        System.out.println(t3[0]);
        t3[0] = new Test3_10_25();

        Test3_10_25 t4 = new Test3_10_25();
        System.out.println(t3[0]);
        System.out.println(t4);
        t3[0] = t4;
        System.out.println(t3[0]==t4);//서로 같은 주소번지를 가짐 -true

    }
}
