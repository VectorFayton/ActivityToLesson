package Problem_B;

public class Fish extends Animal implements Pet {
    private String name;
    Fish(){
        super(0);
    }
    public Fish(String name){
        super(0);
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(String.format("Fish %s is eating", getName()));
    }

    @Override
    public void setName(String Name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName() {

    }

    @Override
    public void play() {
        System.out.println(String.format("Fish %s is playing", getName()));
    }

    public void walk(){
        System.out.println(String.format("Fish %s isn't walking",getName()));
    }
}
