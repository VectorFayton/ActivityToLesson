
public class Cat extends Mammal
{
    public Cat(String name) {
        super(name);
    }

    public void greets()
    {
        System.out.println("meow");
    }
    @Override
    public String toString() {
        return String.format("Cat[%s]", super.toString());
    }
}