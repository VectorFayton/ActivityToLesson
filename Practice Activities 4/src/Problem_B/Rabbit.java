package Problem_B;

public class Rabbit extends Animal implements Pet{
    String Name;
    public Rabbit(String name){
        super(4);
        this.Name = name;
    }
    public Rabbit(){
        this("Vasya");
    }
    @Override
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public void setName() {

    }


    @Override
    public void play() {
        System.out.println(String.format("Rabbit %s is playing", getName()));
    }

    @Override
    public void walk() {
        super.walk();
    }

    @Override
    public void eat(){
        System.out.println(String.format("Rabbit %s is eating", getName()));
    }

}
