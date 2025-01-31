package classes_10_17.day2_10_21;

public class hap_10_21 {
    public static void main(String[] args) {
        int i;
        int hap = 0;
            for(i = 1; i<=5; i=i+1) {
                hap = hap + i;
                System.out.println(hap);
                if (hap == 15){
                    System.out.println("1~5를 더했습니다. 답은 " + hap + " 입니다.");
                }
            }
    }
}
