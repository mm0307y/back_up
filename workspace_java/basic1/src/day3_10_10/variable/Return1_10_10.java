package day3_10_10.variable;

public class Return1_10_10 {
    // 리턴 타입이 void인 hap메소드가 뎃셈한 결과를 화면에 출력하고 싶다.
    // 어떡하지?
    // 리턴 타입이 void이니까 main메소드 즉 hap메소드 밖에서는 더한 결과를
    // 출력할 수 없습니다.
    void hap(int i, int j){
        int result = i + j;
        System.out.println("hep() : 9번 라인" + result);
    }
    int hap1(int i, int j){
        return  i + j;
    }
    String hap2(int i, int j){
        return  i + j + " 입니다.";
    }
    String hap3(int i, int j){
        return  i + j + " 예요.";
    }

    public static void main(String[] args) {
        Return1_10_10 r = new Return1_10_10();
        r.hap(1, 2);
        System.out.println("안녕"); // 파라미터로 입력한 안녕 출력됩니다.
        System.out.println("===================================");
        System.out.println(r.hap1(2,3));
        System.out.println(r.hap2(3,4));
        System.out.println(r.hap3(4,5));
        String dab = r.hap3(1,3);
    }
}
