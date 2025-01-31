package mvc_11_19;

import java.util.*;

public class BoardDao_11_19 {

    /********************************************************************
     * 글쓰기 구현하기
     * insert into mvc_borad values (seq_mvc_board_no.nextval, '글제목', '작성자', '내용', 0, '2024-11-20'); //1 row inserted
     * @param pbvo
     * @return int
     *********************************************************************/
    public int boardInsert(BoardVO_11_19 pbvo) {
        System.out.println("Board Insert called");
        int result = -1;
        return result;
    }

    /********************************************************************
     * 글수정 구현
     * @param pbvo
     * @return int
     * boardUpdate (BoardVO or Map) : int
     * update mvc_board
     * set b_title =: title
     * ,b_content =: content
     * ,b_date = to_char(sysdate, 'YYYY-MM-DD')
     * where b_no =: no;
     *********************************************************************/
    public int boardUpdate(BoardVO_11_19 pbvo) {
        System.out.println("Board Update called");
        int result = -1;
        return result;
    }

    /********************************************************************
     * 글삭제 구현
     * Delete from mvc_board where b_no = ?;
     * @param b_no
     * @return int
    *********************************************************************/
    public int boardDelete(int b_no) {
        System.out.println("Board Delete called");
        int result = -1;
        return result;
    }

    /********************************************************************
     * 글 상세보기 구현
     * select b_no, b_title, b_writer, b_content, b_hit, b_date
     *     from mvc_board
     *    where b_no =: u_no;
     * @param b_no
     * @return Map
     *********************************************************************/
    public Map<String, Object> boardDetail(int b_no) {
        System.out.println("Board Detail called");
        Map<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("b_no", 1);
        rmap.put("b_title", "글제목 1");
        rmap.put("b_writer", "강감찬");
        rmap.put("b_content", "글 내용");
        return rmap;
    }

    /********************************************************************
     * 글 전체조회 구현하기 (조건검색 포함)
     * select b_no, b_title, b_writer, b_content, b_hit, b_date
     *      from mvc_board
     * where b_title like '%'||?||'%'
     *  and b_no > 5
     * @param pbvo
     * @return list
     *********************************************************************/
    public List<Map<String, Object>> boardList(BoardVO_11_19 pbvo) {
        System.out.println("BoardDao Board List Called");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> rmap = new HashMap<>();
        rmap.put("b_no", 1);
        rmap.put("b_title", "글제목 1");
        rmap.put("b_writer", "강감찬");
        list.add(rmap);
        rmap = new HashMap<>();
        rmap.put("b_no", 2);
        rmap.put("b_title", "글제목 2");
        rmap.put("b_writer", "이성계");
        list.add(rmap);
        return list;

    }
}
