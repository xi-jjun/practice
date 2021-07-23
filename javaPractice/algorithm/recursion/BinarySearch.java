public class BinarySearch{
    public static int binarySearch(String[] arr, String target, int begin, int end) {
        if(begin > end) return -1;
        else {
            int mid = (begin + end) / 2;
            int compResult = target.compareTo(arr[mid]);
            if(compResult == 0) return mid;
            else if(compResult < 0) return binarySearch(arr, target, begin, mid - 1);
            else return binarySearch(arr, target, mid + 1, end);
        }
    }
}