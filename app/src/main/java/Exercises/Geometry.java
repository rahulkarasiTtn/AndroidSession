package Exercises;

import java.util.ArrayList;

public class Geometry  {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Rectangle(10,20));
        shapes.add(new Cube(2));
        shapes.add(new Sphere(3));
        shapes.add(new Triangle(8,6,7,8));
        for (Shape f:shapes) {
            f.displayShapeName();
        }
    }
}
