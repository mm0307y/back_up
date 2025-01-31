package classes_10_17.day3_10_22;

public class StringArray1_10_22 {
    public static void main(String[] args) {
        String[] names = null;
        names = new String[3]; // 3개의 공간에 null이 들어있다.
        System.out.println(names);
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        StringArray1_10_22[] sas = new StringArray1_10_22[3];
        StringArray1_10_22 sa = new StringArray1_10_22();
        System.out.println(sa);
        sas[0] = sa; //this
        sas[1] = sa;
        sas[2] = sa;
        System.out.println(sas[0]==sa); //주소번지가 같니? true, equals 구분을 못한다.
        System.out.println(sas[1]==sa); //주소번지가 같니? true
        System.out.println(sas[2]==sa); //주소번지가 같니? true
    }
}
