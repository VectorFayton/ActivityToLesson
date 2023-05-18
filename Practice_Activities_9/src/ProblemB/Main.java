package ProblemB;

public class Main {
    public static void main(String[] args) {
        GeometricObjects[] arr = {new Circle(5), new Circle(8),
                new Rectangle(3, 4), new Rectangle(4, 2)};
        printArray(arr);
        sortArray(arr);
        printArray(arr);
    }
    public static void printArray(GeometricObjects[] objects){
        for (GeometricObjects obj: objects){
            System.out.println(obj.toString());
        }
    }

    public static void sortArray(GeometricObjects[] objects){
        for (int i = 0; i < objects.length; i++){
            for (int j = 0; j < objects.length; j++){
                if (objects[i].compareTo(objects[j]) < 0){
                    GeometricObjects temp = objects[i];
                    objects[i] = objects[j];
                    objects[j] = temp;
                }
            }
        }
    }
}
