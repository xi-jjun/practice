package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i : data) System.out.print(i + " ");

        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        System.out.println("");
        for (int i : data) System.out.print(i + " ");
    }
}
