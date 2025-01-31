package day5_10_14.variable;
/*
7566 - scott - 1900.56
7499 - tiger - 2700
7390 - king - 3100
*/

public class EmpSimulation_10_14 {
    public static void main(String[] args) {
        // 같은 이름의 변수명 이지만 주소번지 값은 서로 다르다.
        Emp_10_14 emp = new Emp_10_14();
        System.out.println(emp);
        emp.empno = 7566;
        emp.ename = "scott";
        emp.salary = 1900.56D;
        System.out.println(emp.empno); // 7566
        System.out.println(emp.ename); // "scott"
        System.out.println(emp.salary); // 1900.56D
        System.out.println("---------------------------------");

        emp = null; // null로 초기화 했다가 다시 인스터스화 할때
        // 바로 위에서 null로 초기화 하였다가 다시 새로 인스터화 하였다.
        emp = new Emp_10_14(); // 변수 이름도 같고 타입도 같지만 새로운 객체생성된다.
        // 아래에서  사원번호가 0이 출력되는 이유는 23번에서
        // 새로운 객체가 생성된다. - 깊은 복사
        System.out.println(emp.empno); // 0
        System.out.println(emp);
        // 기존에 참조되던 객체가 candidate 상태가 된다.
        // 명시적으로 사용한 자원에 대해서 반납 처리하는 것을 권장한다.
        emp.empno = 7499;
        emp.ename = "tiger";
        emp.salary = 2700D;
        System.out.println(emp.empno); // 7499
        System.out.println(emp.ename); // "tiger"
        System.out.println(emp.salary); // 2700D
        System.out.println("---------------------------------");

        emp = null; // null로 초기화 했다가 다시 인스터스화 할때
        emp = new Emp_10_14();
        System.out.println(emp);
        emp.empno = 7390;
        emp.ename = "king";
        emp.salary = 3100D;
        System.out.println(emp.empno); // 7390
        System.out.println(emp.ename); // "king"
        System.out.println(emp.salary); // 3100D
        emp = null;
    }
}
