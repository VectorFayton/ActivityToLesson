import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape{
    int width = 0;
    int height = 0;
    public Shape(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        return this.height * this.width;
    }
}

class Square extends Shape {
    public Square(int side){
        super(side, side);
    }
}

class Rectangle extends Shape {
    public Rectangle(int width, int height){
        super(width, height);
    }
}
public class Test {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        int side = Input.nextInt();
        Square square = new Square(side);
        int width = Input.nextInt();
        int height = Input.nextInt();
        Rectangle rectangle = new Rectangle(width, height);
        shapes.add(square);
        shapes.add(rectangle);
        for(Shape shape : shapes)
            System.out.println(shape.getArea());
    }
}
