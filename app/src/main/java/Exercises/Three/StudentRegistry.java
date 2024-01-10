package Exercises.Three;

import java.util.HashMap;

public class StudentRegistry {
    HashMap<Integer, String> studentRegister = new HashMap<Integer, String>();

    public void addStudent(int id, String name){
       studentRegister.put(id,name);
    }

    public String getStudentById(int id){
      return studentRegister.get(id);
    }

    public void removeStudentById(int id){
       studentRegister.remove(id);
    }

    public static void main(String[] args) {
        //Question-3
        StudentRegistry studentRegistry = new StudentRegistry();
        studentRegistry.addStudent(101,"Rahul");
        studentRegistry.addStudent(102,"Ishita");
        studentRegistry.addStudent(103,"Rohan");
        studentRegistry.addStudent(104,"Ashish");
        studentRegistry.addStudent(100,"Jasmin");
        System.out.println(studentRegistry.getStudentById(102));
        studentRegistry.removeStudentById(102);
        System.out.println(studentRegistry.studentRegister);
    }
}
