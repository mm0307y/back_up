package quiz_10_17.setp1_10_17;

public class Q3 {
    public static void main(String[] args) {
        int x = 5;
        boolean b1 = true; // true or "true"
        boolean b2 = false; // false.boolean 디폴트값은 false입니다.

        // && 그리고 true true, false true false, true false false, false false false
        if((x == 4) && !b2) System.out.print("1 "); // false 이다. 4랑 같니 아니요. 라는 물구라서 두개다 맞아야 되는데 1개만 맞아서 false이다. 그래서 실행 기회를 못 갖는다.
        System.out.print("2 "); // 실행될 기회를 얻는다. 이유는 if문의 좌,우 중괄호가 없어서 if문에 실행문이 아니기 때문에 그렇다.
        if((b2 = true) && b1) System.out.print("3"); // false 이다. 거짓이 맞니? 맞아 라는 답을 줬기 때문에 3을 출력하지 않고 넘어간다.
    }
}
