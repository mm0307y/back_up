package classes_10_17.day3_10_22;

public class ArrayDept2_10_23 {
    public static void main(String[] args) {
        Dept[] depts = new Dept[3];
        Dept d1 = new Dept();
        Dept d2 = new Dept("총무부");
        Dept d3 = new Dept(10,"영업부","제주");
        depts[0] = d1; //0, null, null
        System.out.println(depts[0].getDeptno() + ", " + depts[0].getDname() + ", " + depts[0].getLoc());
        depts[1] = d2; //0, 총무부, null
        System.out.println(depts[1].getDeptno() + ", " + depts[1].getDname() + ", " + depts[1].getLoc());
        depts[2] = d3; //10, 영업부, 제주
        System.out.println(depts[2].getDeptno() + ", " + depts[2].getDname() + ", " + depts[2].getLoc());
    }
}
