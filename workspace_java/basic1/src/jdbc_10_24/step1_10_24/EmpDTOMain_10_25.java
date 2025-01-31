package jdbc_10_24.step1_10_24;
/*오라클 서버와 자바 연동하기
VO(Value Object)클래스 설계가 필요한 이유
DTO(Data Transfer Object) - 부서테이블, 사원테이블, 회원테이블 반복되는 값을 줄이 거나 여러가지의 값을 넘길때 사용한다.
대화내용을 오라클 서버에 저장하기를 구현해 보면 어떨까?*/


public class EmpDTOMain_10_25 {
    //메서드 m은 메서드 오버로딩이다.
    //파라미터의 개수가 다르거나 타입이 다르다.
    void m(int empno, String ename, int deptno){ //사원 집합, 양이 늘어나면 변수를 그만큼 넣어 줘야 하기 때문에 최대한 안쓰는 방향으로 공부하는게 좋다.
        //7566, scott, 10
        System.out.println(empno + " " + ename + " " + deptno);
    }

    //클래스 EmpDTO_10_25에는 변수가 세개 선언 되어있다.
    //메서드의 파라미터 자리는 사용자가 입력한 값을 받는 자리 입니다.
    //사용자와 어플리케이션과 소통이 시작된다.
    void m(EmpDTO_10_25 edto){
        //0, null, 0
        //8000, king, 50
        System.out.println(edto.getEmpno() + " " + edto.getEname() + " " + edto.getDeptno());

    }

    public static void main(String[] args) {
        EmpDTOMain_10_25 etm = new EmpDTOMain_10_25();
        EmpDTO_10_25 dto2 = new EmpDTO_10_25();
        dto2.setEmpno(8000); //private int empno = 8000 - 캡슐화
        dto2.setEname("king");
        dto2.setDeptno(50);

        etm.m(dto2);
        etm.m(7566,"scott",10);

        EmpDTO_10_25 dto = new EmpDTO_10_25();
        dto.setEmpno(7566);
        dto.setEmpno(7499);
        System.out.println(dto.getEmpno());
    }
}
