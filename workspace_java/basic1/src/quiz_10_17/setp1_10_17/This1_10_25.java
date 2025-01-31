package quiz_10_17.setp1_10_17;

class M {
    This1_10_25 this1 = null;
    //인스턴스화를 멤버위치에서 하는 것은 위험하다.
    //This1 this = new This1(); // 핑퐁 - 왔다 갔다 한다. 재귀호출

    public M(This1_10_25 this1) {
        System.out.println("M1 : 멤버 " + this.this1 + ", 지역 : " + this1);
        this.this1 = this1;
        System.out.println("M2 : 멤버 " + this.this1 + ", 지역 : " +this1);
    }
}

public class This1_10_25 {
    M m = new M(this);
    public static void main(String[] args) {
        //변수 이름은 같지만 new 생성자 호출을 두번 했으므로
        //둘은 서로 다른 객체를 참조합니다.(서로 타입은 같다.)
        //인스턴스화를 할 때마다 16번(class M)이 호출 된다.
        This1_10_25 t1 = new This1_10_25(); //여기 주소번지와 20번
        System.out.println("main 1 : " + t1);
        t1 = new This1_10_25(); //여기 주소번지가 다르다.
        System.out.println("main 2 : " + t1);
    }
}
