package Problem_A;

public class Main {
    public static void main(String[] args) {
        int x, y, xSpeed, ySpeed, radius;

        System.out.println("Moving of point");
        for (int i = 0; i <= 10; i++){
            MovablePoint pointA = new MovablePoint(4, 6, 9, -1);
            System.out.println(pointA.toString());
        }

        System.out.println("Moving of Circle");
        for (int i = 0; i <= 10; i++){
            MovableCircle circleA = new MovableCircle(9, 9, 2, 2, 9);
            System.out.println(circleA.toString());
        }
    }
}