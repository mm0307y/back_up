package jdbc_10_24.book_11_04;

import javax.swing.*;
import java.util.List;

public class BookDatTest_11_05 {
    JFrame frame = new JFrame();
    BookDao_11_04 bookDao = new BookDao_11_04();
    public int bookUpdate (BookVO_11_04 pbvo){
        int result = -1;
        pbvo  = new BookVO_11_04();
        pbvo.setB_name("제목8");
        pbvo.setB_author("저자8");
        pbvo.setB_publish("출판사8");
        pbvo.setB_no(8);
        result = bookDao.bookUpdate(pbvo);
        return result;
    }

    public int bookUpdate(int b_no, String b_name, String b_author, String b_publish){
        int result = -1;
        return result;
    }

    public int bookUpdateTest (int b_no){
        int result = -1;
        result = bookDao.bookDelete(b_no);
        return result;
    }

    public void getBookListTest(){
        System.out.println("getBookListTest 호출 성공");
        BookVO_11_04 pbvo = new BookVO_11_04();
        pbvo.setB_no(0);
        List<BookVO_11_04> bList = bookDao.getBookList(pbvo);
        //b_no가 0이면 where 절이 추가되지 않아서 전체 조회가 된다. - 4
        //b_no가 1이면 where 절이 반영되니까 한 건이 조회가 된다. -1
        //b_no가 2이면 where 절이 반영되니까 한 건이 조회가 된다. -1
        //b_no가 3이면 where 절이 반영되니까 한 건이 조회가 된다. -1
        //b_no가 4이면 where 절이 반영되니까 한 건이 조회가 된다. -0

        System.out.println(bList.size());
        System.out.println(bList);
//        System.out.println(bList.get(0).getB_no());
//        System.out.println(bList.get(0).getB_name());
//        System.out.println(bList.get(0).getB_author());
    }

    /*
    자바에서는 입력,  수정, 삭제시에 오토커밋이 일언나고 있다.
    그래서 rollback을 하더라도 이전 상태로 돌아갈 수 없다.
     */

    public static void main(String[] args) {
        BookDatTest_11_05 bdt = new BookDatTest_11_05();
        int result = -1;
        result = bdt.bookUpdate(null);
        System.out.println("성공 여부 : " + result);
        /*result = bdt.bookDeleteTest(4);

        if (result == 1) {
            JOptionPane.showMessageDialog(bdt.frame, "삭제 성공!!!!!!!!!!");
            bdt.getBookListTest();
        }
        else {
            JOptionPane.showMessageDialog(bdt.frame, "삭제 실패!!!!!!!!!!");
//            return; // if문에서 return을 만나면 호출된 메서드를 탈출한다.
        }
        result = -1;
        BookVO_11_04 pbvo = new BookVO_11_04(0,"책제목5","강감찬", "원출판", "책소개5","5.png",null,null);
        result = bdt.bookDao.bookInsert(pbvo);
        if (result == 1) {
            JOptionPane.showMessageDialog(bdt.frame,"입력 성공~~~~");
            bdt.getBookListTest();
        }else {
            JOptionPane.showMessageDialog(bdt.frame,"입력 실패~~~");
            return;
        }*/
    }


}
/*
테스트 시나리오를 알고 있다. -> 잘하는 사람 - 전체 구조파악 - 업무 이해
화면이 없이도 파라미터와 리턴타입을 고려하여 테스가 가능하다.
*/