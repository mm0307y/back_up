package mvc_11_19;

import java.util.*;

public class BoardLogic_11_19 {
    BoardDao_11_19 dao = new BoardDao_11_19();

    //insert here - 객체 주입코드 - BoardDao - 생성자 호출(인스턴스화)
    public BoardVO_11_19 boardInsert(BoardVO_11_19 pbvo){
        System.out.println("Board Insert called");
        BoardVO_11_19 rbvo = new BoardVO_11_19();
        return rbvo;
    }

    public BoardVO_11_19 boardUpdate(BoardVO_11_19 pbvo){
        System.out.println("Board Update called");
        BoardVO_11_19 rbvo = new BoardVO_11_19();
        return rbvo;
    }

    public BoardVO_11_19 boardDelete(BoardVO_11_19 pbvo){
        System.out.println("Board Delete called");
        BoardVO_11_19 rbvo = new BoardVO_11_19();
        return rbvo;
    }

    //select *from mvc_board where b_no = 3
    //select *from mvc_board where b_title = "여행지"
    //public Map<String, Object> boardDetail(String b_title) 파라미터가(사용자가 입력한 값) 글자라면 가로안은 String이 들어가야 한다.
    public Map<String, Object> boardDetail(int b_no){
        System.out.println("Board Detail called" + b_no);
        Map<String, Object> map = new HashMap<String, Object>();
        dao.boardDetail(b_no);
        return map;
    }

    public List<Map<String, Object>> boardList(BoardVO_11_19 pbvo){
        System.out.println("Board List called");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = dao.boardList(pbvo);
        System.out.println("BoardLogic boardList() " + list.size()); //0
        return list;
    }


}
