package quiz_10_17.setp1_10_17;

public class Q35_10_24 {
    public static void main(String[] args) {
        Object ob = new String("Hello");
        System.out.println(ob);
        String msg = (String)ob;
        ob = new int[3];
        System.out.println(ob);
        //Object 타입에 원시형  타입을 담을 수 있다. - 오토박싱
        ob = 3;
        System.out.println(ob);
        //선언부와 생성부가 다른 타입이 올 수 있다.
        //선언부와 생성부가 다를 때 다향성이 성립된다.
    }
}
