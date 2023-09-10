public abstract class Profession {
    protected String activity;
    protected String profession_name;
    protected Profession(String activity, String profession_name){
        this.profession_name = profession_name;
        this.activity = activity;
    }
    public void Action(){
        System.out.printf("%s %s \n", profession_name, activity);
    }
}