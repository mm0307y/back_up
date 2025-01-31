package quiz_10_17.setp1_10_17;

public class Q27_1_10_24 {
    public static void main(String[] args) {
        //index값은 0부터 입니다.
        //index값 관리를 잘 해야 합니다.- 초보가 잘 못 본다.
        int deptnos[] = null;
        try{
            deptnos = new int[3];
            System.out.println(deptnos[3]); //예외가 발생할 가능이 있는 코드이다.
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            System.out.println("무조건 실행된다. 예외와 상관없이...");
        }
    }
}
