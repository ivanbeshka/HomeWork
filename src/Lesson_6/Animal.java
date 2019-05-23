package Lesson_6;

import java.util.Random;

public class Animal {
    public String name;

    public int limitRun;
    public int limitSwim;
    public int limitJump;
    public static Random random = new Random();

    public Animal(String name) {
        this.name = name;
        limitRun = random.nextInt(1000);
        limitSwim = random.nextInt(300);
        limitJump = random.nextInt(5);
    }

    public void run(int meters) {
        if (limitRun == 0) {
            System.out.println(name + " не может бежать");
        } else if (meters <= limitRun) {
            System.out.println(name + " : бег успешно выполнен");
        }else{
            System.out.println("Превышен лимит");
        }
    }

    public void swim(int meters) {
        if (limitSwim == 0) {
            System.out.println(name + " не может плыть");
        } else if (meters <= limitSwim) {
            System.out.println(name + " : плвание успешно выполнено");
        }else{
            System.out.println("Превышен лимит");
        }
    }

    public void jumpLet(int meters) {
        if (limitJump == 0) {
            System.out.println(name + " не может прыгать");
        } else if (meters <= limitJump) {
            System.out.println(name + " : прыжок успешно выполнен");
        }else{
            System.out.println("Превышен лимит");
        }
    }

    public void info() {
        System.out.println(name + "\n" + limitJump + "\n" + limitSwim + "\n" + limitRun);
    }
}
