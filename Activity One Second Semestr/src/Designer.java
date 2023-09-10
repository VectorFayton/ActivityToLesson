public class Designer extends Profession {
    String name;
    int age;
    int salary;
    String activity;
    public Designer(String name, int age, int salary, String activity){
        super(activity, Designer.class.getName());
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.activity = activity;
    }
    @Override
    public void Action(){
        super.Action();
    }
    public void getInfo(){
        System.out.printf("%s is %s. Age: %s. Salary: %s$ \n", name, Designer.class.getName(), age, salary);
    }
}
