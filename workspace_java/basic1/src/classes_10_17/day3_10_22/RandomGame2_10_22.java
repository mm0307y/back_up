package classes_10_17.day3_10_22;

import java.util.Random;
import java.util.Scanner;

public class RandomGame2_10_22 {
    int com = -1;

    public RandomGame2_10_22() {
        //채번하는 메서드를 생성자에서 호출하지 않습니다.
        //왜냐하면 메서드의 재사용성이 떨어집니다. 생성자가 호출될 때 함수도 호출된다.
//        nanSu();
    }

    public void init(){//초기화, 새게임
        nanSu();
    }

    public void initDisplay(){
        System.out.println("initDisplay"); // 3번출력되고
    }

    //timeline
    //메서드 설계에서는 파라미터 타입과 갯수를 결정할 수 있어야 한다.
    //린터 타입도 결정해야 합니다.
    public String account(int userNumber){
        String result = null;
        if (com < userNumber){
            result = "높여라";
        }
        else if (com > userNumber){
            result = "낮춰라";
        }
        else if (com == userNumber){
             result = "정답";
        }
        return result;
    }

    public void nanSu(){
        Random rand = new Random();
        //com숫자는 게임이 진행되는 동안 변경되면 안되니까 멤버변수로 한다.
        com = rand.nextInt(10);
    }

    public static void main(String[] args) {
        RandomGame2_10_22 rg = new RandomGame2_10_22();
        System.out.println("0~9사이의 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int userNumber = -1;
        for (int i = 0; i < 3; i++){
            userNumber = sc.nextInt();
            rg.account(userNumber);
            String result = rg.account(userNumber);
            if (i==2){
                System.out.println("3번의 기회를 모두 사용하였습니다. 정답은 " + rg.com + " 입니다.");
                return;
            }
        }
        if (sc != null){
            sc.close();
        }
    }
}
