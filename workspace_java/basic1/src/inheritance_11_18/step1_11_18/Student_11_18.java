package inheritance_11_18.step1_11_18;

public class Student_11_18 extends Person_11_18 {
    private Major_11_18 major;

    public Student_11_18(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Major_11_18 getMajorOrNull(){
        return this.major;
    }

    public void setMajor(Major_11_18 major){
        this.major = major;
    }

}
