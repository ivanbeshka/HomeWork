package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class XO {
    static final int SIZE = 4;
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true){
            humanTurn();
            printMap();

            if(checkWin(DOT_X)) {
                System.out.println("Вы победитель");
                break;
            }

            if (isFull()){
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if(checkWin(DOT_O)) {
                System.out.println("Компьютер победитель");
                break;
            }

            if (isFull()){
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");

            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Input X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        int full = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    full++;
                }
            }
        }
        return full == 0;
    }

    public static boolean checkWin(char symbol) {

        for (int i = 0; i < SIZE; i++) {
            int check = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol) {
                    check++;
                }
                if (check == DOTS_TO_WIN) {
                    return true;
                }
                if (j == SIZE - 1) {
                    check = 0;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            int check = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symbol) {
                    check++;
                }
                if (check == DOTS_TO_WIN) {
                    return true;
                }
                if (i == SIZE - 1) {
                    check = 0;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            int check = 0;
            if (map[i][i] == symbol) {
                check++;
            }
            if (check == DOTS_TO_WIN) {
                return true;
            }
        }

        int check = 0;
        int j = SIZE - 1;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][j] == symbol){
                check++;
            }
            j--;
            if(check == DOTS_TO_WIN){
                return true;
            }
        }

        return false;
    }
}
