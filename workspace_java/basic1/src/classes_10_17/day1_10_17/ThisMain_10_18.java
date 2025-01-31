package classes_10_17.day1_10_17;

class ThisSub{
    ThisSub(){
        System.out.println("ThisSub 디폴트 생성자");
    }
    ThisSub(ThisMain_10_18 thisMain1018){
        System.out.println(thisMain1018);
        thisMain1018.methodA();
    }
}
/*자기자신에 대한 인스턴스화는 main 메서드 에서 디폴트 생성자가
호출될 때 this 주소번지도 결정된다.
만일 인스턴스화를 하지 않으면 this도 없다.*/
public class ThisMain_10_18 {
    ThisSub obj = new ThisSub(this);

    public ThisMain_10_18() {
        System.out.println("디폴트 생성자 호출");
    }

    //가설 : 만일 객체가 생성되지 않았다면 바로 이때 nullPointerException 발생한다.
    void methodA(){
        System.out.println("ThisMain_10_18 methodA 호출");
    }

    // 21 -> 22 -> 17 -> 18
    public static void main(String[] args) {
        ThisMain_10_18 tm = new ThisMain_10_18();
        tm.methodA();
        System.out.println("main");
    }
}
