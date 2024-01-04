package Exercises;

public class ExerciseTwo {
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(10,20);
        Cube cube = new Cube(2);
        rectangle.setLength(16.0); // setter method to set length
        rectangle.setBreadth(12.0);// setter method to set breadth
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(cube.calculateSurfaceArea());
    }
}
