package classes_10_17.day2_10_21;
/*배열은 한 번 선언하면 크기가 고정이다.
같은 타입만 담을 수 있어서 숫자와 문자열 같은 로우에 답을 수 없다.
*/
public class Array2Main_10_21 {
    public static void main(String[] args) {
        int[][] is = new int[2][3];
        for (int i = 0; i < is.length; i++){ //i는 0일 때 1일 때 두 번 반복된다.
            for(int j = 0; j < is[i].length; j++){ //j는 0일 때 1일 때 2일 때 세번 반복된다.
                System.out.println("is[" + i + "] ["+ j +" ] = "+ is[i][j]);
            } ////end of inner for
        } //// end of for
    } //// end of man
} //// end of Array2Main_10_21
