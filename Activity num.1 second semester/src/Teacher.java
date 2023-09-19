import java.util.ArrayList;

public class Teacher extends Person {
    int numCourses = 0;
    ArrayList<String> courses = new ArrayList<>();
    public Teacher(String name, String address){
        super(name, address);
    }
    public String toString(){
        return Teacher.class.getName() + ":" + super.toString();
    }
    public boolean addCourse(String course){
        boolean bool = true;
            if (courses.contains(course) || numCourses == 5) {
                return false;
            } else{
                courses.add(course);
                numCourses++;
                return true;
        }
    }
    public boolean removeCourse(String course){
        boolean bool = true;
            if (courses.contains(course)){
                courses.remove(course);
                numCourses --;
                return true;
            } else {
                return false;
            }
        }
    }

