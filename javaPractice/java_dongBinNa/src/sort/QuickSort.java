package sort;

public class QuickSort {
    static int[] data = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    static void quickSort(int[] data, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && data[left] <= data[pivot]) left++;
            while (right > start && data[right] >= data[pivot]) right--;

            if (right < left) {
                int temp = data[right];
                data[right] = data[pivot];
                data[pivot] = temp;
            } else {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
        quickSort(data, start, right - 1);
        quickSort(data, right + 1, end);
    }

    public static void main(String[] args) {
        for (int i : data) System.out.print(i + " ");

        quickSort(data, 0, 9);

        System.out.println("");
        for (int i : data) System.out.print(i + " ");
    }
}
