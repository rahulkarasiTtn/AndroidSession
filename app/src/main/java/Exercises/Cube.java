package Exercises;

public class Cube extends Shape implements ThreeDShape{
    private double length;
    public Cube(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    void displayShapeName() {
        System.out.println("This is Cube with Surface Area "+ calculateSurfaceArea() + " and volume "+ calculateVolume());
    }

    @Override
    double calculateArea() {
        return 6*(length*length);
    }

    @Override
    public double calculateVolume() {
        return length*length*length;
    }

    @Override
    public double calculateSurfaceArea() {
        return 6*(length*length);
    }
}
