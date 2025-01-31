package classes_10_17.day3_10_22;

public class ArrayParam1_10_22 {
    void methodA(String[] names){
        for (int i=0; i<names.length; i++){
            System.out.println(names[i]);
        }
    }

    public static void main(String[] args) {
        ArrayParam1_10_22 a =new ArrayParam1_10_22();
        String[] names = {"강감찬", "이순신", "김유신"};
        a.methodA(names);
        System.out.println("methodA가 다 처리되면 여기로 온다.");
    }
}
