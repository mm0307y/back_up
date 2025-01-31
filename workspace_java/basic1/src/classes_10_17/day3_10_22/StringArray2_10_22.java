package classes_10_17.day3_10_22;

public class StringArray2_10_22 {
    public static void main(String[] args) {
        String name = "이성계";
        System.out.println(name); //이성계 출력
        name = "김춘추"; //김춘추를 새로 대입합니다.
        System.out.println(name); // 김춘추 출력
        int [] is = {1,2,3};
        is[1] = 20;
        for (int i=0; i<is.length; i++) {
            System.out.println(is[i]);
        }
        double [] ds = {1,2,3};
        ds[1] = 20;
        for (int i=0; i<is.length; i++) {
            System.out.println(ds[i]);
        }
    }
}
