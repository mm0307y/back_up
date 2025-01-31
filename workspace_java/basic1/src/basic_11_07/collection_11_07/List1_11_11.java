package basic_11_07.collection_11_07;

import jdbc_10_24.book_11_04.BookVO_11_04;

import java.util.ArrayList;
import java.util.List;

public class List1_11_11 {
    public static void main(String[] args) {
        List<BookVO_11_04> list = new ArrayList<>();
        BookVO_11_04 bvo = new BookVO_11_04();
        //b_no = 0, b_name = null, b_author = null
        //초기화를 할수 있다. - 변수에 직접 접근은 불가하다. - private - 캡슐화
        //1) setter 메서드 이용, 2)생성자
        bvo.setB_no(7);
        bvo.setB_name("자바의 정석");
        System.out.println(bvo.getB_no() +  "," + bvo.getB_author() + ", " + bvo.getB_name());
        //같은 변수명 이더라도 생성자를 호출하면 새로운 주소번지를 할당한다.
        bvo = new BookVO_11_04(5,"책제목1", "저자1", "출판사1", "도서소개1", "book1.png", "b_name", "자바의정석1");
        list.add(bvo);
        bvo = new BookVO_11_04(6,"책제목2", "저자2", "출판사2", "도서소개2", "book2.png", "b_name" ,"자바의정석2");
        list.add(bvo);
        bvo = new BookVO_11_04(7,"책제목3", "저자3", "출판사3", "도서소개3", "book3.png", "b_name", "자바의정석3");
        list.add(bvo);
        for (int i = 0; i < list.size(); i++) {
            BookVO_11_04 rbvo = list.get(i);
            System.out.println(rbvo.getB_no() +  "," + rbvo.getB_author() + ", " + rbvo.getB_name());
        }
    }
}
