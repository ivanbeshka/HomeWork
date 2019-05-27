package Lesson_7;

public class Cat {
    private String name;
    private boolean satiety = false;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate, int food) {
        if (food <= plate.getFood()) {
            plate.reduceFood(food);
            System.out.println(name + " eats...");
            setSatiety(true);
            System.out.println(getName() + " сыт(а)");
        }else{
            System.out.println(getName() + " не ел(а)");
        }
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }
}
