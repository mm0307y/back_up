package mvc_11_19;
/*
boardController 에서 BoardLogic 인스턴스화 하기
BoardLogic에서 BoardDao 인스턴스화 하기
*/

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ControllerTest_11_19 {
    BoardController_11_19 bc = new BoardController_11_19();

    //전체조회 테스트
    public List<Map<String, Object>> boardList(BoardVO_11_19 pbvo){
        System.out.println("boardList");
        List<Map<String, Object>> list = bc.boardListAll(pbvo);
        //항상 메서드의 리턴 타입이 null이 올 수 있다는 것을 잊지 말자.
        if (list != null){ //NullPointException을 방지하려 사용하는 코드.
            System.out.println(list);
        }
        return list;
    }

    //select b_no, b_title, b_writer, b_content, b_date, b_hit from mvc_board
    //where b_no =3;
    //BoardController에서 상세조회
    public BoardVO_11_19 boarDetail(BoardVO_11_19 pbvo){
        System.out.println("boardDetail");
        pbvo.setCommand("selectOne");
        //b_title = null, b_writer = null,
        //파라미터에 있는 pbvo와 rbVO가 서로 다르다.
        //rbVOdpsms selectOne이 들어있지 않지만 pbvo에는 selectOne이 들어있다.
        //rbvo에는 한 건을 조회하여 조회된 결과를 담은 주소번지이다.
        BoardVO_11_19 rbVO = bc.send(pbvo); //b_no = 3, command = selectOne
        System.out.println(rbVO.getResult()); //1 : 입력성공, 0 : 입력실패, -1 : 아무것도 한게 없다.
        return rbVO;
    }

    public static void main(String[] args) {
        ControllerTest_11_19 ct = new ControllerTest_11_19();
        //ct.boardList()가 반환 값이 null일 수 있다.
        //NullPointException가 일어날 수 있다.
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 책 번호를 입력하세요.");
//        String b_title = scanner.nextLine();
        int b_no = scanner.nextInt();
        BoardVO_11_19 pbvo = new BoardVO_11_19();
        pbvo.setB_no(b_no);
        BoardVO_11_19 rbVO = ct.boarDetail(pbvo);
        System.out.println(rbVO.getB_no() + " " + pbvo.getB_no()); //1,1
        System.out.println(rbVO.getCommand() + " " + pbvo.getCommand()); //null, selectOne

    }
}
