package day5_10_14.variable;

public class StringTest4_10_14 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
//        StringBuilder sb3 = "Hello";
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb1 == sb2);
        sb1.append(" World");
        System.out.println("after : " + sb1); // Hello World
        // 아래 코드의 경우 String 타입의 클래스가 3번 만들어진다.
        // String 으로 여러 문자열을 만들게 되면 블변객체라서
        // 반드시 대입연산자로 추가된 문자열을 재정의해야 한다. - 두번째 생성된다.

        String query = "SELECT ename, empno"; // 1번
        System.out.println("query : " + query); // SELECT ename, empno

        query = query + " FROM emp"; // 1번
        System.out.println("query : " + query); // SELECT ename, empno FROM emp

        query = query + " WHERE salary > 3000"; // 1번
        System.out.println("query : " + query); // SELECT ename, empno REOM emp WHERE salary > 3000

        StringBuilder query1 = new StringBuilder(); // 1번만 만들어 진다.
        query1.append("SELECT ename, empno");
        query1.append("FROM emp");
        query1.append("WHERE salary = 3000");
        System.out.println(query1);
    }
}
