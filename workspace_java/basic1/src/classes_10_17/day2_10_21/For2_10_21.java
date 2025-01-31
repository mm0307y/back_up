package classes_10_17.day2_10_21;

public class For2_10_21 {
    public static void main(String[] args) {
        int i, hap = 0;
        for (i = 1; i<=5; i++) {
            System.out.printf("i : %d, hap : %d%n", i, hap);
            hap += i;
        }
        System.out.println("1부터 5까지의 합은 " + hap); // 15출력
        // 여기서 hap = 15이다.
        hap = 0;
        for (i = 1; i<=5; i++) { //어떤 숫자를 2로 나눈 나머지가 0이니? -true이면 짝수
            if (i %2 == 0){
                hap +=i;
                System.out.println("짝수 인 값을 더 했습니다." + hap);
            }////end of if
        }////end of for
        System.out.println("1부터 5까지의 합은 " + hap); //21출력
        hap = 0;
        for (i = 1; i<=5; i++) { //어떤 숫자를 2로 나눈 나머지가 0이니? -true이면 짝수
            if (i %2 == 1){
                hap +=i;
                System.out.println("홀수 인 값을 더 했습니다." + hap);
            }////end of if
        }////end of for
        System.out.println("1부터 5까지의 합은 " + hap); //21출력
    }
}