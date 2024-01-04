package Exercises;

public class Triangle extends Shape implements TwoDShape{
    private double base,height,leftSide,rightSide;
    public Triangle(double base, double height, double leftSide, double rightSide) {
        this.base = base;
        this.height = height;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    void displayShapeName() {
        System.out.println("This is Triangle with Perimeter = "+calculatePerimeter()+" and Area = "+calculateArea());
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return leftSide + rightSide + base;
    }

    @Override
    public double numberOfSides() {
        return 3;
    }
}
