public class Dog extends Mammal
{
    public Dog(String name) {
        super(name);
    }

    public void greets(Dog another)
    {
        System.out.println("wooooof");
    }
    public void greets()
    {
        System.out.println("woof");
    }
    @Override
    public String toString() {
        return String.format("Dog[%s]", super.toString());
    }
}