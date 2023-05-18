package Problem_A;

public class MovableCircle implements Movable{
    int radius;
    MovablePoint center;
    int x, y, xSpeed, ySpeed;
    public MovableCircle(int radius, int x, int y, int xSpeed, int ySpeed) {
        MovablePoint center_point = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        this.center.moveUp();
    }

    @Override
    public void moveDown() {
        this.center.moveDown();
    }

    @Override
    public void moveLeft() {
        this.center.moveLeft();
    }

    @Override
    public void moveRight() {
        this.center.moveRight();
    }

    public String toString(){
        return String.format("(%s, %s), speed = (%s, %s), radius = %s", x, y, xSpeed, ySpeed, radius);
    }
}
