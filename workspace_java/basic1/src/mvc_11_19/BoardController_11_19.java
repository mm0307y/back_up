package mvc_11_19;
/*
1. 일반화 / 특정화 고나점에서 이해하는 방법
2. 기능의 고나점에서 이해하는 방법
- 공통(DBConnectionMgr, Person) 클래스를 만들고
그로부터  상속받은  상태와 기능을 재활용해 보기*/


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BoardController_11_19 {
    BoardLogic_11_19 bLogic = new BoardLogic_11_19();

    public static final String _ALL = "selectAll"; //리턴타입 - List<Map<>>, List<BoardVO>
    public static final String _ONE= "selectOne"; //Map or BoardVO
    public static final String _INS= "insert"; //int
    public static final String _UPD= "update"; //int
    public static final String _DEL= "delete"; //int
    //insert, update, delete는 int
    //한건조회는 BoardVO

    public BoardVO_11_19 send(BoardVO_11_19 pbvo){
        String command  = pbvo.getCommand();
        BoardVO_11_19 rbvo = new BoardVO_11_19();
        System.out.println("dalj" + command);
        if (_INS.equals(command)){ //글 등록이라면?
            System.out.println("글등록 메시지 호출 성공");
            //pbvo에는 사용자가 입력한 글제목, 글내용, 글작성자
            //insert into mvc_board values(?, ?, ?..)
            rbvo = bLogic.boardInsert(pbvo);
        }
        else if (_UPD.equals(command)){ //글 수정이라면?
            System.out.println("글등록 메시지 수정 성공");
            bLogic.boardUpdate(pbvo);
        }
        else  if (_DEL.equals(command)){ //글 삭제라면?
            System.out.println("글등록 메시지 삭제 성공");
            bLogic.boardDelete(pbvo);
        }
        else  if (_ONE.equals(command)){ //상세보기라면?
            System.out.println("글등록 메시지 상세보기 성공");
            Map<String, Object> rmap = bLogic.boardDetail(pbvo.getB_no());
            rbvo.setB_no(Integer.parseInt(rmap.get("B_no").toString()));
            rbvo.setB_title(rmap.get("B_title").toString());
            rbvo.setB_writer(rmap.get("B_writer").toString());
            rbvo.setB_content(rmap.get("B_content").toString());
            System.out.println();
        }
        return rbvo;
    }


    //전체 조회 구현하기와 조건 검색구현하기 같이 공유 가능하다.
    //select * from mvc_board
    //where b_title like '%'||?||'%'
    //where b_no = ?
    //조건절에 들어갈 값은 화면에서 결정 되는 것이다.
    public List<Map<String, Object>> boardListAll(BoardVO_11_19 pbvo){
        System.out.println("전체 조회 호출 성공");
        //사용자로 부터 입력 받은 값 넘기기
        List<Map<String, Object>> bList = bLogic.boardList(pbvo);
        return bList;
    }
}
