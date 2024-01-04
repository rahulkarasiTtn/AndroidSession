package Exercises;

public class Cylinder extends Shape implements ThreeDShape{
    private int radius,height;

    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0;
    }

    @Override
    void displayShapeName() {
        System.out.println("This is Cylinder with Surface Area "+calculateSurfaceArea()+" and Volume = "+calculateVolume());
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius,2) * height;
    }

    @Override
    public double calculateSurfaceArea() {
        return (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius,2));
    }
}
