public class Main {
    public static void main(String[] args) {
        Animal pig = new Animal("Pig");
        Mammal bober = new Mammal("Bober");
        Cat Barsik = new Cat("Barsik");
        Dog Ruslan = new Dog("Ruslan");
        System.out.println(pig.toString());
        System.out.println(Barsik.toString());
        Barsik.greets();
        System.out.println(Ruslan.toString());
        Ruslan.greets();
        Ruslan.greets(Ruslan);
    }
}