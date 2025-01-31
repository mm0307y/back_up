package inheritance_11_18.step1_11_18;

public class StudentTest_11_18 {
    public static void main(String[] args) {
        Person_11_18 person1 = null;
        person1 = new Person_11_18("John", "Smith");
        System.out.println(person1 instanceof Person_11_18); //true 참
        System.out.println(person1 instanceof Student_11_18); //false 거짓
        System.out.println(person1 instanceof Teacher_11_18); //false 거짓
        System.out.println(person1.getFullName());
        person1 = new Student_11_18("키위", "김");
        System.out.println(person1 instanceof Person_11_18); //true 참
        System.out.println(person1 instanceof Student_11_18); //true 참
        System.out.println(person1 instanceof Teacher_11_18); //false 거짓
        System.out.println(person1.getFullName());
        Student_11_18 student = new Student_11_18("사과", "김");
        Person_11_18 person2 = new Person_11_18("John", "Smith");
        //오른쪽에 더 큰 타입이 오는 건 형전환 연산자로 문법적인 문제는 해결할 수 있지만
        //결국 에러가 발생한다.
//        student = (Student_11_18) person2;
        System.out.println(student instanceof Person_11_18); //true 참
        System.out.println(student instanceof Student_11_18); //true 참
        //부모가 같으니까 Teacher와도 관계가 있는 건 아닌가? - 아무 관계도 아니다.
//        System.out.println(student instanceof Teacher_11_18); //아무 상관도 없는 클래스이다. 에러

    }
}
