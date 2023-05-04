package Shapes;

public class Rectangle extends Shape {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * (height + width));
    }

    @Override
    protected void calculateArea() {
        setPerimeter(height * width);
    }
}
