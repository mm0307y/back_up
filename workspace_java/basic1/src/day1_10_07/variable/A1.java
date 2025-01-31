package day1_10_07.variable;

public class A1 {
    public static void main(String[] args) {
        String address;
        //insert here
        address = "서울시 종로구 공덕동";
        address = "서울시 금천구 가산동";

        address = "서울시 영등포구 당산동";
        System.out.println(address);//지변인데 초기화를 하지 않아서 에러 발생
        System.out.println(address);//지변인데 초기화를 하지 않아서 에러 발생
        //그러면 A1.java는 존재하지만 A1.class는 생성되지 않는다.
        //어디서 확인하면 되나요? out>production>day1>variable
        //A1.class가 보이지 않아요 - 컴파일 실패가 발생했기때문에
        //원인은 지변을 초기화 하지 않았기 때문에
        //고려할 내용은 선언이 먼저 사용은 나중 - 위치
    }
}
