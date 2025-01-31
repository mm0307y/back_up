package day3_10_10.variable;

public class B_10_10 {
    public static void main(String[] args) {
        int i  = 1;
        double avg = 0.5;
        i = (int)avg;
        // 처음에 i는 1이었지만 7번라인에서 강제전환이 되었기 때문에
        // 실수 0.5는 담을 수 없고(왜냐하면 크기가 달러서, 타입이 다르니까)
        // 그럼에도 불구하고 꼭 담고 싶다면 0만 담을수 있어. 알아서해
        System.out.println(i); // 0이 출력될거야
        avg = i;
        System.out.println(avg); // 0.5가 출력된다. | 아니다. 0이 출력된다. 아니다 1이다.
    }
}
