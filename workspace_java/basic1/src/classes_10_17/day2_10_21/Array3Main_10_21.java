package classes_10_17.day2_10_21;

public class Array3Main_10_21 {
    public static void main(String[] args) {
        /*3*4 = 12 개의 칸이 생긴다.
        12을 접근 ㅏ려면 변수가 2개 필요하다.
        변수가 2개 필요하다는건 for문을 중첩해서 두 번 사용해야 한다는 것이다.
        구구단출력하는 프로그램을 작성하기*/
        
        int[][] a = new int[3][4]; // ArrayIndexOutOfBoundsException
        a[0] = new int[4];
        System.out.println(a[0]); //1차 배열을 참조하는 변수이다.
        a[1] = new int[4];
        a[2] = new int[4];
        System.out.println(a.length); //로우의 값을 반환한다.
        int row = a.length; //3
        int col = a[0].length; //4
        int col1 = a[1].length; //4
        int col2 = a[2].length; //4
        int col3 = a[3].length; //4 ArrayIndexOutOfBoundsException
    }
}
