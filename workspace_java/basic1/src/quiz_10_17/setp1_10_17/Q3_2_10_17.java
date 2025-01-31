package quiz_10_17.setp1_10_17;

public class Q3_2_10_17 {
    public static void main(String[] args) {
        int x = 2;
        int y = ++x; // x++ -> x = x + 1, y = 3, x = 3
        /* x++ < y-- ? 3 < 3 false 인데 & 하나이므로 앞에 조건이 false이더라도
        처음이 false이면 두번째가 true이더라고 false이다.
        두 번째 조건 -> x++ 이면 증가 연산자가 뒤에 있으니가 작은지를 먼저 비교하고
        그다음에 1을 증가해줘 x = 4, y = 2
        두 번째 조건을 따져보자 5 >= 3*/


        if ((x++ < y--) && (++x >= ++y)){
//        if((x++ < y--) & (++x >= ++y)){
          // 4 < 2 false   5 >= 3
            System.out.println("참일 때 : x - " + x + ", y - " + y);
        }
        else {
            System.out.println("거짓 일때 : x - " + x + ", y - " + y);
        }
    }
}
