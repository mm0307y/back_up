package classes_10_17.ui_10_18.combo_10_30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List1_10_30 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List list3 = new ArrayList();
        String name1 = new String("John");
        String name2 = new String("Jane");
        String name3 = new String("Jack");
        list1.add(name1);
        list2.add(name1);
        list3.add(name1);
        list1.add(name2);
        list1.add(name3);
        String n1 = list1.get(0);
        //insert here
        String n2 = (String) list2.get(0); //타입이 달라서 오류
        String n3 = (String) list3.get(0); //제네릭이 없어서 오류, 리스트안에 뭐가 들어가 있는지 몰라서
        //즉 정확하게 타입이 안 정해졌기 때문에 오류가 발생한거다.(n2, n3)
        System.out.println(n1 + n2 + n3);

    }
}
