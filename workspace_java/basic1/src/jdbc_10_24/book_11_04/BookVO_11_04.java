package jdbc_10_24.book_11_04;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
//그러나 본인의 경우 상황에서 따라 사용하지 않고 공부하기
public class BookVO_11_04 {
    private int b_no;
    private String b_name; //책제목5
    private String b_author; //강감찬
    private String b_publish; //원출판
    private String b_info; //책소개5
    //여기서 파일 업로드 처리는 하지 않습니다. 그래서 이미지 이름만 저장합니다.
    private String b_img; //5.png
    //VO가 테이블에 존재하는 컬럼만 사용할 수 있는 것은 아닙니다.
    //테이블에 존재하는 컬럼은 아니지만 조건검색을 위해서 필요한 변수 추가
    private String gubun = "전체"; //b_name, b_author, b_publish
    //사용자가 입력한 조건검색 키워드 읽기와 쓰기
    private String keyword;
}