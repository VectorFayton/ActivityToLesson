public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.5, "red", false);
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getColor());
        System.out.println(circle.isFilled());
        System.out.println(circle.getRadius());
        Rectangle rectangle = new Rectangle(3.8, 2.5, "green", false);
        System.out.println(rectangle);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getColor());
        System.out.println(rectangle.getLength());
        Square square = new Square(6.6);
        System.out.println(square);
        System.out.println(square.getArea());
        System.out.println(square.getColor());
        System.out.println(square.getSide());
    }
}