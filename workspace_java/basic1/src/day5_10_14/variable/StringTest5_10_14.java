package day5_10_14.variable;

import java.util.Scanner;

public class StringTest5_10_14 {
    public static void main(String[] args) {
        // 아이디 입력
        String mem_id = "tomato";
        String user_id = null; // 입력을 하게 되면 재정의가 되서 주소번지는 다르게 생성된다.

        // 비밀버호 입력
        String mem_pw = "1234";
        String user_pw = null;
        // 파라미터에 System.in은 로컬 컴퓨터에서 입력받은 값을
        // 기다리게 됩니다.

        Scanner sc = new Scanner(System.in); // 사용자로 부터 입력을 받는 코드
        System.out.println("아이디를 입력하세요.");
        user_id = sc.nextLine();

        System.out.println("비밀번호를 입력하세요.");
        user_pw = sc.nextLine();
        System.out.println("사용자가 입력한 아이디는 " + user_id + " 입니다.");

        /*
        문자열 변수에 저장돼 있는 건 값이 아니라 메모리 주소이다.
        따라서 ==가 비교하는 대상은?
        주소를 비교한다.
        그 주소에 있는 실제 문자열을 비교하는게 아니다.
        */

        if (mem_id == user_id) { // 주소번지가 같니?
            // 실행이라고 하면 조건을 만족하지 않으면 단 한 번도 실행이 안된다.
            // 조건을 실행문 보다 먼저 따지므로 조건이 false 이면 한 번도 실행이 안된다.
            // 참일 때만 if 문 좌, 우 중괄호에 문장이 실행됩니다.
            System.out.println("아이디가 맞습니다.(주소번지가 같다.)");
        }
        else { // if 문의 괄호 안에 조건을 수렴하지 않으면 그때 실행된다.
            System.out.println("아이디가 틀립니다. (주소번지가 달라요.)");
        }

        if (mem_pw == user_pw) {
            System.out.println("비밀번호가 맞습니다. (주소번지가 같다.)");
        }
        else {
            System.out.println("비밀번호가 틀립니다.(주소번지가 다르다.)");
        }
        System.out.println("----------------------------------------------------");

        if(mem_id.equals(user_id)) { // 아이디 중복검사라고 가정하면
            System.out.println("당신이 입력한 아이디 " + user_id + " 는 사용할 수 없습니다.");
        }
        else {
            System.out.println("당신이 입력한 아이디 사용 가능합니다.");
        }

        if(user_pw.length() < 4) {
            System.out.println("입력한 비빌번호가 짧습니다.");
        }
        else {
            System.out.println("사용 가능합니다.");
        }
    }
}
