package jdbc_10_24.Test_11_06;

//생성자 - 메서드 오버로딩 - API보는 능력 - 파라미터와 갯수가 다르거나 타입이 달라야 한다.
//재사용성, 다형성, fly()
class AVO{
    private int age; //나이 - 멤버변수는 초기화를 생략할 수 있다.
    private String name; //이름

    AVO(){}

    AVO(int age){
        this.age = age;
    }

    AVO(String name){
        this.name = name;
    }

    AVO(int age, String name){
        this.age = age;
        this.name = name;
    }

    AVO(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() { //파라미터가 없다 - 대신 return이 있다.
        return name;
    }

    //setter에는 return이 없다.
    public void setName(String name) { //파라미터 - 값을 주면 기억해 줄께
        this.name = name;
    }
}

public class AVOMain_11_06 {
    public static void main(String[] args) {
        //나이를 초기화 하세요 - 30
        AVO avo = new AVO(30, "강감찬");
        avo.setAge(50);
        avo.setName("이성계");
        System.out.println(avo.getAge()); //30 -> 50
        //변수는 한 번에 하나만 기억할 수 있다.
        System.out.println(avo.getName()); //강감찬 -> 이성계


    }
}
