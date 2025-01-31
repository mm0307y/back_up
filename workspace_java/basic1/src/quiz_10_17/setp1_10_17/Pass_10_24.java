package quiz_10_17.setp1_10_17;

public class Pass_10_24 {
    int x = 1;
    //6-7-8-11-12(5출력)-9(5출력)
    public static void main(String[] args) {
        int x = 5;  //main에서 선언된 지역변수
        Pass_10_24 p = new Pass_10_24();
        p.doStuff(p);
        System.out.println("main x = " + p.x);
    }
    void doStuff(Pass_10_24 p) {
        System.out.println("doStuff x = " + ++p.x);  //x를 증가시키기전에 출력한다.
    }
}
