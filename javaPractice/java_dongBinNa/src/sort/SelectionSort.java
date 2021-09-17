package sort;

import java.util.Arrays;

public class SelectionSort {
    static final int SIZE = 100000;

    public static void main(String[] args) {
        int[] sel = new int[SIZE]; // Selection Sort TEST
        int[] sys = new int[SIZE]; // System function TEST
        long startTime, endTime;

        // random array generate
        for (int i = 0; i < SIZE; i++) {
            double value = Math.random();
            sel[i] = (int) (value * SIZE);
            sys[i] = (int) (value * SIZE);
        }


        // "가장 작은 것을 앞으로" Selection Sort
        startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            int min = sel[i];
            int index = -1;

            for (int j = i + 1; j < SIZE; j++) {
                if (min > sel[j]) {
                    min = sel[j];
                    index = j;
                }
            }
            if (index == -1) continue; // already sorted

            int temp = sel[i];
            sel[i] = sel[index];
            sel[index] = temp;
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
