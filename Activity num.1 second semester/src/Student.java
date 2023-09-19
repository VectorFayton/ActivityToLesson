import java.util.ArrayList;

public class Student extends Person {
    int numCourses = 0;
    ArrayList<String> courses = new ArrayList<>();
    ArrayList<Integer> grades = new ArrayList<>();
    public Student(String name, String address){
        super(name, address);
    }
    public String toString(){
        return Student.class.getName() + super.toString();
    }
    public void addCourseGrade(String course, int grade){
        if (numCourses <= 30) {
            courses.add(course);
            grades.add(grade);
            numCourses++;
        }
    }
    public void printGrades(){
        for(int i = 0; i < grades.size(); i++){
            System.out.printf("%s:%s", courses.get(i), grades.get(i));
        }
    }
    public double getAverageGrade(){
        int sum = 0;
        int count = 0;
        for (int i = 0; i < grades.size(); i++){
            sum = sum + grades.get(i);
            if (grades.get(i) != 0)
            {
                count++;
            }
        }
        return sum / count;
    }
}
