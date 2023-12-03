package Test;

public class Mammal extends Animal{

    public Mammal (String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Test.Mammal[%s]", super.toString());
    }
}