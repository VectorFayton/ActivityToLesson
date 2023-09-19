import java.util.ArrayList;
import java.util.Collection;

public class MyArrayListCapacity {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.5);
        list.trimToSize();
        list.add(3.4);
        list.add(7.4);
        list.add(17.4);
        System.out.println();
    }
}
