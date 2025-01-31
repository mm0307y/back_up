package day5_10_14.variable;

import java.util.Scanner;

public class StringTest6_10_14 {
    public static void main(String[] args) {
        String mem_id = "kiwi";
        String uesr_id = null;
        Scanner sc = new Scanner(System.in);
        uesr_id = sc.nextLine(); // 재치환 될때 새로운 주소번지가 할당됩니다.
        System.out.println(mem_id == uesr_id); // false
    }
}
