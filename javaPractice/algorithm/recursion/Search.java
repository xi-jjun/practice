public class Search{
    public static int search(int[] arr, int start, int end, int target) {
        if(start > end) return -1;
        else if(arr[start] == target) return start;
        else return search(arr, start + 1, end, target);
    }
}