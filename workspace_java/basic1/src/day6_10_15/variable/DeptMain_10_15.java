package day6_10_15.variable;
class Dept{
    int deptno; // 디폴트가 0
    String dname; // null, ""아니고 null 디폴트가 맞다.
    String loc; // null
} //// end of Dept

public class DeptMain_10_15 {
    void effectParam(Dept dept){
        // dept = new Dept(); // p = new Param()
        dept.deptno = 100;
        // main에서 출력되기 전에 먼저 출력된다. - 순서, 위치
        System.out.println("sub deptno " + dept.deptno); // 100 출력
    } //// end od effectParam

    public static void main(String[] args) {
        DeptMain_10_15 obj = new DeptMain_10_15();
        Dept dept = new Dept();
        dept.deptno = 500;
        obj.effectParam(dept);
        // effectParam 먼저 호출 했잖아. 그래서 그 다음에 println 있잖아요.
        System.out.println("sub deptno " + dept.deptno); // 2번째 출력된다. 100 출력
    } //// end of main
} //// end of DeptMain
