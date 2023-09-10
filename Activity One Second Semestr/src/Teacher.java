public class Teacher extends Profession{
    String name;
    int age;
    int salary;
    String activity;
    public Teacher(String name, int age, int salary, String activity){
        super(activity, Teacher.class.getName());
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public void Action(){
        super.Action();
    }

    public void getInfo(){
        System.out.printf("%s is %s. Age: %s. Salary: %s$ \n", name, Teacher.class.getName(), age, salary);
    }
}
