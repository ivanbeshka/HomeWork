package Lesson_7;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Barsik");
        cat[1] = new Cat("Murka");
        cat[2] = new Cat("Sharik");

        Plate plate = new Plate(15);

        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate, 10);
        }
    }
}
