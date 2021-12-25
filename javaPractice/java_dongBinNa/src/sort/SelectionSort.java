package sort;

import java.util.Arrays;

public class SelectionSort {
    static final int SIZE = 100;

    public static void main(String[] args) {
        int[] sel = new int[SIZE]; // Selection Sort TEST
        int[] sys = new int[SIZE]; // System function TEST
        long startTime, endTime;

//        // random array generate
//        for (int i = 0; i < SIZE; i++) {
//            double value = Math.random();
//            sel[i] = (int) (value * SIZE);
//            sys[i] = (int) (value * SIZE);
//        }
        sel = new int[]{79, 14, 32, 7, 18, 9, 37, 28};

        // "가장 작은 것을 앞으로" Selection Sort
        startTime = System.currentTimeMillis();
        for (int i = 0; i < sel.length; i++) {
            int min = sel[i];
            int index = -1;

            for (int j = i + 1; j < sel.length; j++) {
                if (min > sel[j]) {
                    min = sel[j];
                    index = j;
                }
            }
            if (index == -1) continue; // already sorted

            int temp = sel[i];
            sel[i] = sel[index];
            sel[index] = temp;
            for (int i1 : sel) {
                System.out.print(i1 + " ");
            }
            System.out.println("");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Selection sort time : " + (endTime - startTime) + "ms");


        // Java Sort
        startTime = System.currentTimeMillis();
        Arrays.sort(sys);
        endTime = System.currentTimeMillis();
        System.out.println("Java sort time : " + (endTime - startTime) + "ms");

    }
}
