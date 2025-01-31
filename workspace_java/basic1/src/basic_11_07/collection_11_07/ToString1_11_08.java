package basic_11_07.collection_11_07;

import javax.swing.*;

class P1 extends Object{
    JButton btn = new JButton("Click Me");
    @Override
    public String toString(){
        return "P1";
    }
}

public class ToString1_11_08 {
    public static void main(String[] args) {
        P1 p1 = new P1();
        System.out.println(p1);
        System.out.println(p1.toString());
        System.out.println(p1.btn); //여기서는 주소번지가 아니라 오버라이드된 결과가 출력한다.
    }
}
