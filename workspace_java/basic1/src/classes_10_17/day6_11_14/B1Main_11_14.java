package classes_10_17.day6_11_14;

import java.util.Scanner;

//사용자로 부터 두 수를 입력 받아서 두수의 합을 구하는 메서드를 구현하시오.
class B1{
    int hap(int first, int second, String oper){
        int res = 0;
        if ("+".equals(oper)){
            res = first + second;
        }
        else if ("-".equals(oper)){
            res = first - second;
        }
        else if ("*".equals(oper)){
            res = first * second;
        }
        else if("/".equals(oper)){
            res = first / second;
        }
        return res;
    }
}

public class B1Main_11_14 {

    public static void main(String[] args) {
        System.out.println("첫 번재 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int first = 0;
        first = sc.nextInt();

        System.out.println("두번째 숫자를 입력하세요.");
        int second = 0;
        second = sc.nextInt();

        System.out.println("연산자를 입력하세요.(예 : +, -, *, /)");
        String oper = null;
        oper = sc.next();

        B1 b1 = new B1();
        int result = b1.hap(first, second, oper);
        System.out.println("두 수의 합은 : " + result);
    }
}
