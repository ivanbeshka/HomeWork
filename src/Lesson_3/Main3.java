package Lesson_3;

import java.util.Random;
import java.util.Scanner;

public class Main3 {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int play = 1;
        while(1 == play) {
        int a = rand.nextInt(10);
        for (int i = 0; i < 3; i++) {
            System.out.println("Vvedite cislo");
            int vvod = sc.nextInt();

            if (a == vvod) {
                System.out.println("Vy ygadali cislo" + "\n");
                break;
            }else{
                System.out.println("Vy ne ygadali cislo" + "\n");
            }

        }
            System.out.println("Play again?");
            play = sc.nextInt();
        }
    }
}
