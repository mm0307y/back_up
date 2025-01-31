package classes_10_17.day3_10_22;

import java.util.Random;
/*여러분들은 클래스를 설계할 때 멤버변ㄴ수로 할지 지역변수로 할지를 결정할 수 있다.
기초 인가? 아닐 때도 많았다.*/

public class RandomGame1_10_22 {
    /*생성자를 최대한 활용하기 - 초기화
    채번하기
    1) 메서드로 구현하기
    2) 생성자에서 하는 방법
    둘 중 재사용성이 우수한 쪽은 어디인가요?
    문제제기 - 만일 깊은 복사를 결정했다면? - 인스턴스화가 여러번 발생된다.
    주소번지가 바뀐다. -> 같은 타입의 클래스가 동시에 heap영역에 존재한다.
    그 때마다 새로운 숫자가 채번된다면 정답이 계속 바뀌어도 되는 건가요?
    권장하는 방법은 채번하기 구현은 사용자 정의 메서드로 처리하세요.
    만일 새게임 버튼이 있다면.. 가정해 보기
    새게임 버튼이 눌릴 때 마다 채번하는 메서드가 호출되어야 한다.
    이것이 화면을 그리는 것과 무관하게 독립적으로 처리되어야 하지 않을까?*/

    int com;

    public RandomGame1_10_22() {
        initDisplay();
        nanSu();
    }

    public void initDisplay(){
        System.out.println("initDisplay"); // 3번출력되고
    }

    public String 판정(int userNumber){
        String account = null;
        if (com < userNumber){
            account = "높여라";
        }
        else if (com > userNumber){
            account = "낮춰라";
        }
        else if (com == userNumber){
            account = "정답";
        }
        return account;
    }

    //0~9사이의 임의의 수 를 채번하기
    public void nanSu(){
//        System.out.println("nanSu"); // 3번출력된다. - 정답숫자이다.
        Random rand = new Random();
        //컴퓨터가 채번한 숫자는 반드시 멤버변수로 해야 합니다. - 학습목표
        int com = rand.nextInt(10); //0은 포함하고 10은 포함하지 않는다. 즉 0~9까지 이다. 채번된 숫자가 정답이 된다.
        //정답은 게임이 유지되는 동안에 변하면 안된다.
        //인스턴스변수로 변경한다는 것은 멤버변수를 말하는것이다. | 아니다.
        //rg1.i = 100; rg1.i = 500
//        RandomGame1_10_22 rg1 = new RandomGame1_10_22(); //한 사람이다. | 여러명일 수도 있다.
//        RandomGame1_10_22 rg2 = new RandomGame1_10_22();
//        RandomGame1_10_22 rg3 = new RandomGame1_10_22();
    }

    public static void main(String[] args) {
        RandomGame1_10_22 rg = new RandomGame1_10_22();
        System.out.println(rg); // 여기 주소번지와
        rg = new RandomGame1_10_22();
        System.out.println(rg); // 여기 주소번지가 다르다. - 깊은 복사
        rg = new RandomGame1_10_22();
        System.out.println(rg); // 여기 주소번지가 또한 다른다.
    }
}
