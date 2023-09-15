import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Persons> list_of_persons = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list_of_persons.add((new Persons(names[i], heights[i])));
        }
        List<Persons> sorted_list_of_persons = list_of_persons.stream().sorted(Comparator.comparing(Persons::getHeight).reversed()).collect(Collectors.toList());
        String[] sorted_array_of_persons = new String[sorted_list_of_persons.size()];
        for (int i = 0; i < sorted_list_of_persons.size(); i++) {
            sorted_array_of_persons[i] = String.valueOf(sorted_list_of_persons.get(i));
        }
        return sorted_array_of_persons;
    }
}

class Persons{
    String name;
    int height;
    public Persons (String name, int height){
        this.height = height;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}

public class Main{
    public static void main(String[] args) {
        String[] names = new String[]{"Bob", "Alice", "Alex"};
        int[] heights = {170, 180, 160};
        String[] hey =  new Solution().sortPeople(names, heights);
        for (int i = 0; i < names.length; i++) {
            System.out.println(hey[i]);
        }
    }
}