package classes_10_17.day3_10_22;

public class ArrayReturn1_10_22 {
    String names[] = {"김유신", "이성계", "강감찬"};
    String[] methodA(){
        return names;
    }

    public static void main(String[] args) {
        ArrayReturn1_10_22  ar1 = new ArrayReturn1_10_22();
        String[] names = ar1.methodA();
        //김춘추는 어디서 나온 건가요?
        names[1] = "김춘추";
        names[2] = null;
        for (int i=0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        System.out.println("여기");
    }
}
