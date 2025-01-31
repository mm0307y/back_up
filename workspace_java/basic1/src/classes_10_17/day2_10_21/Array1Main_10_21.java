package classes_10_17.day2_10_21;
class Array1 {
    //원시형 타입의 1차 배열입니다.
    //is.length : 배열의 길이를 반환합니다. - 3이 출력됩니다.
    //초기값은 : is[0] = 0, is[1] = 0, is[2] = 0
    int is[] = new int[3];
}

public class Array1Main_10_21 {
    Array1 a = new Array1();
    void print1(){
        for(int i = 0; i < a.is.length; i++){
            System.out.println("a.is[" + i + "] = " + a.is[i]); // 0 0 0 출력합니다. 원시형 배열
        }
    }

    public static void main(String[] args) {
        Array1Main_10_21 a1m =  new Array1Main_10_21();;
        a1m.print1();
    }
}
