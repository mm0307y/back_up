package classes_10_17.quiz_10_21;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_10_21 {
    //멤버이긴 하지만 전역이진 않아서 사용이 불가하다.main
    int com = -1; // end of file
    //멤버(클래스 밖에서도 접근이 가능하다.)

    public RandomGame_10_21() {
        //로컬(지역)(클래스 밖에서는 접근이 불가능하다.)
        Random r = new Random();
        nanstPrint(r);
        com = r.nextInt(10);
    }

    //단위테스트와 통합테스트를 하는 사람
    //테스트 시나리오를 적어내는 개발자들. - 해본자.
    //게임 진행하기
    public void goGame(){
        System.out.println("0부터 9사이의 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
    }

    public void nanstPrint(Random r){
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(10));
        }
    }

    public static void main(String[] args) {
        RandomGame_10_21 rg = new RandomGame_10_21();
        rg.goGame();
    }
}
