package quiz_10_17.setp1_10_17;

public class Q29_10_24 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        int y[] = x;
        int a,b = 1;
        int a1[],b1 = 1;
        a1 = new int[3]; //지역변수는 어떤한 상황에서도 초기화를 해야 한다.
        System.out.println(a1);
        System.out.println(a1 instanceof Object);
        /*타입을 확인하고 싶을때 사용한다. instanceof
        화면단과 서버가 만나는 부분에서 필요합니다. (타입체크)
        왜냐면 타입이 다르니까*/
        System.out.println(b1);
        //배열기호가 앞에 있으면 뒤에 오는 변수도 배열이다.
//        int []a2,b2 = 2;
        int []a3,b3 = null;
        int []a5,b5 = new int[]{1, 2, 3, 4, 5};
        a5 =new int[]{1, 2, 3, 4, 5};
        System.out.println(a5[3]); //4
        System.out.println(b5[3]); //4
    }
}
