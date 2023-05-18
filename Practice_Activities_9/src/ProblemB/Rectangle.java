package ProblemB;

public class Rectangle extends GeometricObjects{
    int width;
    int height;
    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int getArea(){
        return width * height;
    }
    public String toString(){
        return String.format("Rectangle: %s", getArea());
    }
}
