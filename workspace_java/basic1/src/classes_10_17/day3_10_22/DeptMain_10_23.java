package classes_10_17.day3_10_22;
/*오라클에서 생성된 테이블을 자바의 클래스로 설계했다.
오라클에서 컬러명은 변수로 이해해 보자.
Value Object역할을 수행하는 클래스로 설계하였다.
하나의 클래스에 여려개의 멤버변수를 선언할 수 있다.
서로 관련이 있는 하나의 로우를 담을 수 있는 클래스이다.
객체배열을 사용할 수 있다. - n개의 로우도 담을 수 있다.
단 고정형이다. - 단점-한번 크기를 정하면 변경이 불가하다.
Value Object의 역할을 수행하는 클래스는 List나 Map의
제네릭으로 사용할 수 있다.(완결편) - 쿠키와 세션(time 제어)-인증, 인가, 상태값 관리
초기화*/

class Dept{
    private int deptno = 0;
    private String dname = null; //NullPointerException
    private String loc = null; //NullPointerException
    Dept(){}
    Dept(String dname){
        this.dname = dname;
    }
    /*나는 생성자를 활용할 수 있다.
    나는 생성자를 통해서 멤버변수의 초기화를 할 수 있다.
    나는 여러가지의 생성자를 재정의하여 상황에 따라 선택하여 호출할 수 있다.
    나는 this를 사용해야 하는 이유에 대해 말할수 있다.*/

    Dept(int deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    //접근제한자 private은 내 클래스 안에서만 접근이 가능하다.
    //SELECT deptno, dname, loc FORM dept;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}////end of Dept

public class DeptMain_10_23 {
    public static void main(String[] args) {
        Dept d = new Dept();
        System.out.println(d); //여기 주소번지랑 64번 주소번지가 다르다.
        System.out.println(d.getDname()); //null
        System.out.println(d.getDeptno()); //10
        d.setDeptno(100);
        System.out.println(d.getDeptno()); //100
        Dept d2 = null;
        d2 = d;
        d = new Dept("총무부");
//        System.out.println(d);
        System.out.println(d2);
        System.out.println(d.getDname()); //null
        System.out.println(d.getLoc()); //NEW YORK
    }
}
