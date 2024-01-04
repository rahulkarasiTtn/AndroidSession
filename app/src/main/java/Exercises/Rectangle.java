package Exercises;

public class Rectangle extends Shape implements TwoDShape {
    public Rectangle(double length , double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    private double length ,breadth;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    @Override
    double calculateArea() {
        return length*breadth;
    }

    @Override
    void displayShapeName() {
        System.out.println("This is Rectangle with area = " + calculateArea()+" perimeter = "+ calculatePerimeter());
    }

    @Override
    public double calculatePerimeter() {
        return 2*(length+breadth);
    }

    @Override
    public double numberOfSides() {
        return 4;
    }
}
