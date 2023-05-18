import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class StudyingSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("String");
        list.get(0);
        list.remove(0);
        for (String values : list){
            System.out.println(values);
        }
        Iterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Set<String> set = new HashSet<String>();
        set.add("string1");
        set.add("string1");
        set.add("string2");
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        for (String values : set){
            System.out.println(values);
        }
        set.remove("string1");
    }
}
