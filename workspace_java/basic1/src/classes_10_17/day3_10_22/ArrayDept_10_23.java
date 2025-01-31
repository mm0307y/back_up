package classes_10_17.day3_10_22;

public class ArrayDept_10_23 {

    public static void main(String[] args) {
        Dept[] depts = new Dept[]{new Dept(10,"총무부","인천"), new Dept(20,"영업부","서울"), new Dept(30,"개발부","부산")};
        for (int i = 0; i<depts.length; i++) {
            System.out.println(depts[i]); //깊은복사 - 3개의 주소번지가 다 달라요
            System.out.println(depts[i].getDeptno() + ", " + depts[i].getDname() + "," + depts[i].getLoc()); //깊은복사 - 3개의 주소번지가 다 달라요
        }
    }
}
