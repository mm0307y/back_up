package basic_11_07.collection_11_07;

import java.util.ArrayList;
import java.util.List;

class List22 {
    List<String> names = new ArrayList<>();
    List22(){
        System.out.println("디폴트 생성자 호출");
        names.add("John");
        names.add("Scott");
        names.add("Tiger");

    }
    List22(int i){
        System.out.println("List22(int i) 생성자 호출");
        names = null;
    }
}

public class List21_11_12 {
    public static void main(String[] args) {
        List22 list2 = new List22();
        System.out.println(list2.names.size()); //3
        List22 list = new List22(1);
        System.out.println(list.names.size()); //NullPointerException
    }
}
