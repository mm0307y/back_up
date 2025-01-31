package jdbc_10_24.step1_10_24;

public class DeptDTO_10_25 {
    int deptno;
    String dname;
    String loc;
    public int getDeptno() {
        return deptno;
    }

    public DeptDTO_10_25(){
        //0, null, null
    }

    public DeptDTO_10_25(int deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}