package Lesson_6;

public class Main {
    public static void main(String[] args) {

        Cat c1 = new Cat("Murzik");
        Dog d1 = new Dog("Sharik");

        c1.info();
        d1.info();
        d1.jumpLet(1);
        c1.swim(2);
        d1.run(500);
        c1.run(300);
    }
}
