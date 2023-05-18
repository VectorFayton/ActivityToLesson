import java.util.Random;

public class Rectangle extends Shape{
    private double width = 1.0f;
    private double length = 1.0f;

    public Rectangle()
    {}

    public Rectangle(double width, double length)
    {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea()
    {
        return length * width;
    }

    public double getPerimeter()
    {
        return 2 * (length * width);
    }

    public String toString()
    {
        return "Rectangle[" + super.toString() + ", width = " + width + ",length = " + length + "]";
    }
}