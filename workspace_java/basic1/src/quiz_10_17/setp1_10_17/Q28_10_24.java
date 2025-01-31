package quiz_10_17.setp1_10_17;

public class Q28_10_24 {
    int x = 12;

    public void method(int x) { //x=5
        System.out.println("method Q28 첫번째 : " + this);
        this.x += x;  //x = x + x; => x = 5 + 5;
        System.out.println(x);
        System.out.println(this.x);
    }
    //자바에서는 같은 이름의 메서드를 여러개 가질수 있다.
    //단 파라미터의 갯수가 다르거나 타입이 달라야 한다. - 메서드 오버로딩이라고 한다.
    public void method(int x, Q28_10_24 q) {
        System.out.println("method Q28 두번째 : " + this);
        this.x = x + x;  //x = x + x; => x = 5 + 5;
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(q.x);
    }
    //this는 변한다.
    //언제? 인스턴스화를 두번 했더니 변한다. - 주소번지가 따라서 바뀐다.
    public static void main(String[] args) {
        Q28_10_24 q = new Q28_10_24();
        System.out.println("main Q28 첫번째 : " + q);
        q.x = 10;
        q.method(5);
        q = new Q28_10_24();
        System.out.println("main Q28 두번째 : " + q);
        q.method(5, q);
    }
}


