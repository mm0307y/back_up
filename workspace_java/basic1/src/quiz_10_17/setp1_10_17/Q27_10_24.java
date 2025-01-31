package quiz_10_17.setp1_10_17;
//디버깅이 프로개밍에 50%이상을 차지한다.
public class Q27_10_24 {
    public static void parse(String str){
        float f = 1;
        try{
            f = Float.parseFloat(str); //"invalid"가 가로안에 들어가 있다.
        } catch (Exception e) {
            f = 3.5f;
            //System.exit(0); //자바 가상머신과 연결고리르 끊는다.
            //위 문장이 실행되면 finally를 작성햇더라도 실행기회를 갖지 못한다.
        }finally { //예외가 발생하든 하지 않던지 무조건 실행된다.
            //예외가 발생하더라도 무조건 실행되어야 하면 finally에 작성할 것.
            System.out.println(f);
        }
    }
    //15-16-4-6-7
    public static void main(String[] args) {
        //실수형을 초기화 할 때 f 리터널을 붙이지 않으면 double이다.
        Q27_10_24.parse("1.5");
    }
}
