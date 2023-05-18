package Problem_B;

public class Spider extends Animal{
    public Spider(int legs) {
        super(legs);
    }

    @Override
    public void eat(){
        System.out.println(String.format("Spider eat"));
    }

    @Override
    public void walk(){
        super.walk();
    }
}
