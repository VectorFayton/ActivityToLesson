package ProblemB;

public abstract class GeometricObjects implements Comparable<GeometricObjects>{
    public abstract int getArea();
    public abstract String toString();

    @Override
    public int compareTo(GeometricObjects object){
        if (this.getArea() > object.getArea()){
            return 1;
        } else if (this.getArea() < object.getArea()){
            return  -1;
        } else
            return 0;
    }
}
