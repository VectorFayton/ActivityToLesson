package Problem_B;

public class Main {

    public static void main(String[] args) {
        Rabbit leonardo = new Rabbit("Loenardo");
        leonardo.eat();
        leonardo.play();
        leonardo.walk();
        System.out.println(leonardo.toString());
        Spider spider = new Spider(8);
        spider.eat();
        spider.walk();
        Fish neredo = new Fish("Neredo");
        neredo.eat();
        neredo.play();
        neredo.walk();

    }
}
