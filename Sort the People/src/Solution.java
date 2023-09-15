import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
//    public String[] sortPeople(String[] names, int[] heights) {
//
//    }
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List<Persons> list_of_persons  = Arrays.asList(new Persons("Gera", 180), new Persons("Bob", 120), new Persons("Fedya", 190));

        List<Persons> sorted_list_of_persons = list_of_persons.stream().sorted(Comparator.comparing(Persons::getHeight)).collect(Collectors.toList());
        sorted_list_of_persons.forEach(System.out::println);
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