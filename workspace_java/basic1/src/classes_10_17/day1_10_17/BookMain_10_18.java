package classes_10_17.day1_10_17;

class BookSub{
    BookSub(int year){
        System.out.println("BookSub(int) : " + year);
    }
    BookSub(String title){
        System.out.println("BookSub(String) : "  + title);
    }
}

public class BookMain_10_18 {
    /*디폴트 생성자가 없으면 JVM이 제공한다.
    파라미터가 있는 생성자는 제공이 불가한다. - 파라미터를 알 수 없으니까*/
    BookSub bs = new BookSub("Hello");

    public static void main(String[] args) {
//        new BookSub(2024);
//        new BookSub("2024");
        new BookMain_10_18();

    }
}
