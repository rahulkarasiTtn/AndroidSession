package MockTest;

public class Developer extends Employee{
    private int employeeId, salary;
    private String employeeName,languageKnown;

    public Developer(int employeeId, String employeeName, int salary,String languageKnown) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.languageKnown = languageKnown;
    }

    @Override
    void printDetail() {
        System.out.println("Employee Id : "+employeeId);
        System.out.println("Employee Name : "+employeeName);
        System.out.println("Salary : "+salary);
        System.out.println("Language known : "+languageKnown);
    }
}
