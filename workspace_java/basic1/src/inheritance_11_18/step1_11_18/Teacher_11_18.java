package inheritance_11_18.step1_11_18;

public class Teacher_11_18 extends Person_11_18{
    private Department_11_18 department;
    public Teacher_11_18(String firstName, String lastName, Department_11_18 department) {
        super(firstName, lastName);
        this.department = department;
    }

    public Department_11_18 getDepartmentOrNull() {
        return this.department;
    }

    public void setDepartment(Department_11_18 department){
        this.department = department;
    }
}
