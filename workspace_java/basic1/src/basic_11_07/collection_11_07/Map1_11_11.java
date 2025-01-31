package basic_11_07.collection_11_07;

import jdbc_10_24.book_11_04.BookVO_11_04;
import org.apache.ibatis.ognl.Ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//bvo = new BookVO_11_04(5,"책제목1", "저자1", "출판사1", "도서소개1", "book1.png", "b_name", "자바의정석1");
public class Map1_11_11 {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("b_no", 5);
        map.put("b_name", "책제목1");
        map.put("b_author", "저자1");
        map.put("b_publish", "출판사1");
        map.put("b_info", "도서소개1");
        map.put("b_img", "book1.png");
        map.put("gubun", "b_name");
        map.put("keyword", "자바의정석1");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("b_no", 6);
        map.put("b_name", "책제목2");
        map.put("b_author", "저자2");
        map.put("b_publish", "출판사2");
        map.put("b_info", "도서소개2");
        map.put("b_img", "book2.png");
        map.put("gubun", "b_name");
        map.put("keyword", "자바의정석2");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("b_no", 7);
        map.put("b_name", "책제목3");
        map.put("b_author", "저자3");
        map.put("b_publish", "출판사3");
        map.put("b_info", "도서소개3");
        map.put("b_img", "book3.png");
        map.put("gubun", "b_name");
        map.put("keyword", "자바의정석3");
        list.add(map);
        System.out.println(list.size()); //3
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map1 = list.get(i);
            System.out.println(map1.get("b_no") + ", " + map1.get("b_name") + ", " + map1.get("b_author") + ", " + map1.get("b_publish") + ", " + map1.get("b_info") + ", " + map1.get("b_img") + ", " + map1.get("gubun") + ", " + map1.get("keyword"));
        }
//        for (Map<String, Object> map1 : list) {
//            System.out.println(map1.get("b_no") + ", " + map1.get("b_name") + ", " + map1.get("b_author") + ", " + map1.get("b_publish") + ", " + map1.get("b_info") + ", " + map1.get("b_img") + ", " + map1.get("gubun") + ", " + map1.get("keyword"));
//        }
    }
}
