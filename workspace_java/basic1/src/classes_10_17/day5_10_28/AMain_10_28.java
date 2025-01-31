package classes_10_17.day5_10_28;
class A{
    private int no = 0; //0에서 10으로 바뀐다.
    private String name = null;

    public int getNO(){
        return no;
    }
    public void setNO(int no){
//        this.no = no; //파라미터로 넘어오는 값을 멤버변수에 초기화하기
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class AMain_10_28 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getNO());
//        a.no = 1;
        A a1 = new A();
        a1.setNO(10); //A클래스의 멤버에 10이 저장된다.
        System.out.println(a1.getNO());
        a1.setName("홍길동");
        System.out.println(a1.getName());
    }
}
