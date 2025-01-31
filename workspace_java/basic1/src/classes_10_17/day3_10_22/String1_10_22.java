package classes_10_17.day3_10_22;

public class String1_10_22 {
    public static void main(String[] args) {
        String mem_id1 = "kiwi";
        String mem_id2 = "kiwi";
        String mem_id3 = new String("kiwi");
        String mem_id4 = new String("tomato");
        System.out.println(mem_id1==mem_id2); //주소번지가 같니? true
        System.out.println(mem_id1==mem_id3); //false
        System.out.println(mem_id2==mem_id3); //false
        System.out.println(mem_id3==mem_id4); //false
        System.out.println(mem_id1.equals(mem_id2)); //문자열 kiwi랑 문자열 kiwi랑 같니? true
        System.out.println(mem_id1.equals(mem_id3)); //문자열 kiwi랑 문자열 kiwi랑 같니? true
        System.out.println(mem_id3.equals(mem_id4)); //문자열 kiwi랑 문자열 tomati랑 같니? false
    }
}
