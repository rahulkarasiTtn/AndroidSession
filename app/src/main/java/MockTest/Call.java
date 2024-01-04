package MockTest;

import java.util.ArrayList;

import Exercises.Shape;

public class Call {
    public static void main(String[] args){
        ArrayList<Employee> employee = new ArrayList<Employee>();
        employee.add(new Manager(1111,12111111,"kautaliya","Forte"));
        employee.add(new Developer(1211,"Rahul",3000,"JavaScript"));
        for (Employee e:employee) {
            e.printDetail();
            System.out.println("---------------------------");
        }
    }
}
