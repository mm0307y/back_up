package classes_10_17.ui_10_18.combo_10_30;

import java.util.Vector;

public class StringArray_10_30 {
    public static void main(String[] args) {
        String[] strs = null; //나는 크기를 정할 수가 없었다. 왜냐면 그때 그때 달라서
        //크기를 결정할 수 없으면 선언과 생성을 분리해야 한다.
        Vector<String> v = new Vector<>();
        v.add("전체");
        v.add("서울");
        v.add("경기");
        v.add("부산");
        //System.out.println(strs.length); //NullPointerException
        //4개라는 사실ㅇ을 누구를 통해서 알 수 있나요? v.size()
        strs = new String[v.size()];
        v.copyInto(strs); //복사 붙여 넣기 기능으로 내가 지정한 횟수만큼 복제해준다.
        for (String s:strs){
            System.out.println(s);
        }
    }
}
