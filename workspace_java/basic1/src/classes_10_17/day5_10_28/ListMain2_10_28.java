package classes_10_17.day5_10_28;

import java.util.ArrayList;
import java.util.List;

public class ListMain2_10_28 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        System.out.println(list.size()); //0
        list.add("A"); //list.get(0) - A
        list.add("B"); //list.get(1) - B
        list.add("C"); //list.get(2) - C
        System.out.println(list.size()); //3
        boolean isOk = list.remove("B");
        System.out.println(isOk); //true
//        String result = list.remove(0); //A출력
//        System.out.println(result); //A
        String result1 = list.remove(1); //C출력
        System.out.println(result1);
        System.out.println(list.isEmpty()); //false, 아무것도 없으면 true출력 된다.
        if (list.contains("A")){
            System.out.println("A가 있어요.");
        }else {
            System.out.println("A가 없아요.");
        }
    }
}
