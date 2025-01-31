package classes_10_17.day2_10_21;

public class For1_10_21 {
    public static void main(String[] args) {
        int i;
        //for문에서 선언(타입)한 변수는 좌,우 중 괄호 안에서만 접근 가능하다.
        for(i=0; i<3; i = i+1){
            System.out.println(i); // 0 1 2
        }
        //for문 조건을 만족하지 않으니까 빠져 나왔다.
        System.out.println("i가 3이면 여기로 빠짐 - for 문을 탈출한다. - " + i);
    }
}
