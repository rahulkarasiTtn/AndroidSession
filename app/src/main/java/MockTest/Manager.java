package MockTest;

public class Manager extends Employee{

    private int employeeId, salary;
    private String employeeName,project;

    public Manager(int employeeId, int salary, String employeeName, String project) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.employeeName = employeeName;
        this.project = project;
    }

    @Override
    void printDetail() {
        System.out.println("Employee Id : "+employeeId);
        System.out.println("Employee Name : "+employeeName);
        System.out.println("Salary : "+salary);
        System.out.println("Project : "+project);
    }
}
