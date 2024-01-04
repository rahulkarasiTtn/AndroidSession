package Exercises;

public class Sphere extends Shape implements ThreeDShape{
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 0;
    }

    @Override
    void displayShapeName() {
        System.out.println("This is Sphere with Surface Area "+calculateSurfaceArea()+" and Volume = "+calculateVolume());
    }

    @Override
    public double calculateVolume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double calculateSurfaceArea() {
        return 4* Math.PI * Math.pow(radius,2);
    }
}



