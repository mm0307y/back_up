package quiz_10_17.setp1_10_17;
class T{
    int a = 1;
    T(){
        System.out.println("T()디폴트 생성자 호출 성공");
    }
    T(Test1_10_25 test1){
        System.out.println("파라미터가 있는 생성자 호출 성공");
        System.out.println(this.a); // 여기서 출력되는 주소번지가
    }
}

public class Test1_10_25 {
    //this가 참조하는 타입은 class 선언 다음에 오는 타입으로 결정된다.
    //그러니깐 그 때마다 다른거다.
    T t = new T(this);

    public static void main(String[] args) {
        Test1_10_25 test1 = new Test1_10_25();
        //여기서 출력되는 주소번지와 같은 것이다.
        System.out.println(test1.t.a); //1
        test1.t.a = 10;
        System.out.println(test1.t.a); //10
        //생성자가 두 번 호출된다.
        test1 = new Test1_10_25();
        System.out.println(test1.t.a); //1
    }
}
