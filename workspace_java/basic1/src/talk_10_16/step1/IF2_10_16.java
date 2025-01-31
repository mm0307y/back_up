package talk_10_16.step1;

public class IF2_10_16 {
    public static void main(String[] args) {
    int jumsu = 85;
    if(jumsu <= 100 && jumsu >= 90) {
        System.out.println("A학점");
    }
    else if(jumsu < 90 && jumsu >= 80) {
        System.out.println("B학점");
    }
    else if(jumsu < 80 && jumsu >= 70) {
        System.out.println("C학점");
    }
    else {
        System.out.println("F학점"); // 14번 라인의 조건에 대한 나머지 F학점
    }
    ////// 여기에 한 번더 확인
    System.out.println("여기로 온다.");
    }
}
