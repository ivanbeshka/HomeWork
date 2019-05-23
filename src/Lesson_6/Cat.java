package Lesson_6;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int meters) {
        super.run(meters);
    }

    @Override
    public void jumpLet(int meters) {
        super.jumpLet(meters);
    }

    @Override
    public void swim(int meters) {
        super.limitSwim = 0;
        super.swim(meters);

    }
}
