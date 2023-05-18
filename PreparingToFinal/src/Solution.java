import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner Input = new Scanner(System.in);
        int size = Input.nextInt();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i <= size; i++) {
            list.add(Input.nextLine());
        }
        ArrayList<String> list1 = list;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list1.get(i).contains(list.get(j))) {
                    list1.remove(i);
                }
            }
        }
        System.out.println(list1.toString());
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
