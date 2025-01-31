package inheritance_11_18.step1_11_18;

//확장성 - email 관리하기를 원한다. 어떡하지
public class Person_11_18 {
    String firstName;
    String lastName;

    Person_11_18(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    String changName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        return firstName + " " + lastName;
    }
}