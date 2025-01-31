package classes_10_17.day3_10_22;

public class TryCatch_10_23 {
    public static void main(String[] args) {
        int is[] = new int[3];
        try {
            System.out.println(is[2]);
        }
        catch (Exception e) {
            System.out.println("예외가 발생하였다. " + e.toString());
        }
        System.out.println("여기까지 실행기회가 없다. - 예외가 발생하더라도 후처리를 해야한다.");
    }
}
