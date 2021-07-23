public class FindMax{
    public static int findMax(int[] arr, int begin, int end) {
        if(begin == end) return arr[begin];
        else return Math.max(arr[begin], findMax(arr, begin + 1, end));
    }

    public static int findMax2(int[] arr, int begin, int end) {
        if(begin == end) return arr[begin];
        else {
            int mid = (begin + end) / 2;
            int max1 = findMax2(arr,begin, mid);
            int max2 = findMax2(arr,mid + 1, end);
            return Math.max(max1, max2);
        }
    }
}