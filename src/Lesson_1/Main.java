package Lesson_1;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        double b = 1.21;
        String c = "Hello";
        boolean d = true;
        char e = 'E';


    }

    public static int calc(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean interval(int a, int b) {
        return (a + b) < 10 || (a + b) > 20 ? false : true;
    }

    public static String cislo(int a) {
        String res;

        if (a >= 0) {
            res = "plus";
        } else {
            res = "minus";
        }
        return res;
    }

    public static boolean otricatelnoeCislo(int a) {
        if (a < 0)
            return true;

        return false;
    }

    public static String sayHello(String name) {
        return "Hello " + name +" !";
    }

    public static String visokosnyiGod (int year) {
        String res;
        if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0) {
            res = "visokosnyi";
        } else {
            res = "nevisokosnyi";
        }
        return res;
    }
}
