package quiz_10_17.setp1_10_17;
class DeptDTO{
    int deptno;
    String dname;
    String loc;

    DeptDTO(){
        //0, null, null
    }

    DeptDTO(int deptno, String deptname, String loc){
        this.deptno = deptno;
        this.dname = deptname;
        this.loc = loc;
    }
}

public class DeptMain_10_25 {
    public static void main(String[] args) {
        DeptDTO[] dept = new DeptDTO[3];
        DeptDTO dto = new DeptDTO(10, "총무부", "인천");
        //주소번지가 언제 바뀌나요?
        dept[0] = dto;
        System.out.println(dept[0].deptno); //10
        System.out.println(dept[0] == dept[1]);
        System.out.println(dept[1] == dept[2]);
        //여기는 계속 같은 번지가 유지되고 있다.

        dto = new DeptDTO(20, "영업부", "서울");
        //주소번지 변화
        dept[1] = dto;
        System.out.println(dept[1].deptno); //20
        System.out.println(dept[1].dname); //영엉부
        System.out.println(dept[1].loc); //서울
        System.out.println(dto.deptno); //20
        System.out.println(dto.dname); //영영부
        System.out.println(dto.loc); //서울
        System.out.println(dept[1].deptno); //20
        dto = new DeptDTO(30, "개발부", "부산");
        //주소번지 변화
        dept[2] = dto;
        System.out.println(dept[2].deptno); //30
        System.out.println(dept[2].dname); //개발부
        System.out.println(dept[2].loc); //부산
        System.out.println(dto.deptno); //30
        System.out.println(dto.dname); //개발부
        System.out.println(dto.loc); //부산
    }
}
