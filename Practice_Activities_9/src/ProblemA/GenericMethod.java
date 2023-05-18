package ProblemA;
import java.util.*;
public class GenericMethod {
        public static void main(String[] args) {
            ArrayList<Number> list = new ArrayList<>();
            list.add(1);
            list.add(2L);
            list.add(3.00);
            list.add(4.56F);
            System.out.println(sum(list));
        }

        public static double sum(ArrayList<Number> array) {
            double sum = 0;
            for (Number num : array) {
                sum += num.doubleValue();
            }
            return sum;
        }
}