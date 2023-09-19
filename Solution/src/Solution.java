import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List<Person> Person = Arrays.asList(
                new Person("mary", 180),
                new Person("john", 160),
                new Person("Emma", 190)
        );
        for (int i = 0; i < 3; i++) {
            Person.add(new Person(Input.nextLine(), Input.nextInt()));
        }
        List sortedList = Person.stream()
                .sorted(Comparator.comparingInt(Person::getHeight))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

    }
};
class Person {
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

    String name;
    int height;
    public Person(String name, int height){
        this.name = name;
        this.height = height;
    }

    public String toString(){
        return name + ":" + height;
    }
}