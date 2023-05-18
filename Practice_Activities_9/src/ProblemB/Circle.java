package ProblemB;

public class Circle extends GeometricObjects {
    int radius;
    Circle(int radius){
        this.radius = radius;
    }
    public int getArea(){
        return (int) (Math.pow(radius, 2) * Math.PI);
    }

    public String toString(){
        return String.format("Circle: %s", getArea());
    }
}
