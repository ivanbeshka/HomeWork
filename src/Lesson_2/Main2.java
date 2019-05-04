package Lesson_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        //№1
        int[] arr = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        //№2
        int[] arr2 = new int[8];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] *= 3;
        }

        //№3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }

        //№4
        int[][] arrKvadrat = new int[10][10];

        for (int i = 0; i < arrKvadrat.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arrKvadrat[i].length; j++) {
                    if (j % 2 == 0) {
                        arrKvadrat[i][j] = 1;
                    }
                }
            }
            if (i % 2 == 1) {
                for (int j = 0; j < arrKvadrat[i].length; j++) {
                    if (j % 2 == 1) {
                        arrKvadrat[i][j] = 1;
                    }
                }
            }
        }

        //№5
        int[] arr4 = {1, 10, 2, 5, 12, 30};
        int max = arr4[0];
        int min = arr4[0];

        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] < min) {
                min = arr4[i];
            }
            if (arr4[i] > max) {
                max = arr4[i];
            }
        }
    }


    //№6
    public static boolean middleSum(int[] arr) {
        int left = 0;
        int right = 0;
        int count = 1;

        for (; count < arr.length; count++) {
            left = arr[count - 1];
            right = arr[arr.length - count];

            if (right == left){
                return true;
            }
        }
        return false;
    }


    //№7
    public static void stepArr(int[] arr, int n) {

        if (n > 0) {
            for (; 0 < n; n--) {
                int save = arr[arr.length - 1];

                for (int i = 1; i < arr.length; i++) {
                    arr[arr.length - i] = arr[arr.length - (i + 1)];
                }

                arr[0] = save;
            }
        }

        if (n < 0) {
            for (; 0 > n; n++) {
                int save = arr[0];

                for (int i = 0; i < (arr.length - 1); i++) {
                    arr[i] = arr[i + 1];
                }

                arr[arr.length - 1] = save;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}