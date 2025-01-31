package classes_10_17.quiz_10_21;

import java.util.Random;
import java.util.Scanner;

public class RG_10_21 {
    int com; // 컴퓨터가 생성한 랜덤 숫자

    public RG_10_21() {
        Random r = new Random();
        com = r.nextInt(10); // 0부터 9 사이의 랜덤 숫자 생성
        nanstPrint(r); // 0부터 9 사이의 숫자를 10개 출력
        System.out.println("컴퓨터가 채번한 숫자(정답) : " + com);
    }

    // 게임 진행하기
    public void goGame() {
        System.out.println("0부터 9 사이의 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);

        // 사용자가 맞출 때까지 반복
        for (;;) { // 무한 루프
            System.out.print("입력: ");
            int userInput = sc.nextInt();

            // 유효성 검사
            if (userInput < 0 || userInput > 9) {
                System.out.println("잘못된 입력입니다. 0부터 9 사이의 숫자를 입력하세요.");
                continue; // 잘못된 입력 시 다시 반복
            }

            // 정답 확인
            if (userInput == com) {
                System.out.println("정답입니다! 컴퓨터가 생성한 숫자: " + com);
                break; // 정답일 경우 반복 종료
            }
            else if (userInput > com){
                System.out.println("입력한 숫자가 큽니다. " + userInput);
            }
            else if (userInput < com) {
                System.out.println("입력한 숫자가 작습니다. " + userInput);
            }
            else {
                System.out.println("틀렸습니다. 다시 시도하세요.");
            }
        }
        sc.close(); // 스캐너 닫기
/*        // 최대 5번의 시도 기회
        for (int attempt = 1; attempt <= 5; attempt++) {
            System.out.print("입력 (시도 " + attempt + "): ");
            int userInput = sc.nextInt();

            // 유효성 검사
            if (userInput < 0 || userInput > 9) {
                System.out.println("잘못된 입력입니다. 0부터 9 사이의 숫자를 입력하세요.");
                attempt--; // 잘못된 입력 시 시도 횟수 감소
                continue; // 잘못된 입력 시 다시 반복
            }

            // 정답 확인
            if (userInput == com) {
                System.out.println("정답입니다! 컴퓨터가 생성한 숫자: " + com);
                break; // 정답일 경우 반복 종료
            } else {
                System.out.println("틀렸습니다. 다시 시도하세요.");
            }
        }
        sc.close(); // 스캐너 닫기*/
    }

    // 0부터 9 사이의 랜덤 숫자를 10개 출력
    public void nanstPrint(Random r) {
//        System.out.println("랜덤 숫자 10개:");
        for (int i = 0; i < 10; i++) {
//            System.out.println(r.nextInt(10));
        }
    }

    public static void main(String[] args) {
        RG_10_21 rg = new RG_10_21(); // 게임 인스턴스 생성
        rg.goGame(); // 게임 시작
    }
}
