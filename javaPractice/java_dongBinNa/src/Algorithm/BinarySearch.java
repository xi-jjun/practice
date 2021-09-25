package Algorithm;

public class BinarySearch {
    static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, end);

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 5, 7, 8, 10, 14, 16, 36, 75, 80};

        System.out.println(binarySearch(data, 6, 0, data.length - 1));
    }
}
