package search;

public class BinarySearch {

    static int binarySearch(int[] data, int start, int end, int target) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (data[mid] == target) return mid;

        if (data[mid] > target) {
            return binarySearch(data, start, mid - 1, target);
        } else {
            return binarySearch(data, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(binarySearch(data, 0, 9, 3));
    }
}
