package sort;

public class QuickSort {
    static int[] data = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    static void quickSort(int[] data, int start, int end) {
        if (start >= end) return; // 시작 지점이 끝 지점의 index 보다 크면 교차된 것이므로 함수 종료.

        int pivot = start; // pivot값의 index는 배열의 맨 처음 위치
        int left = start + 1; //
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
