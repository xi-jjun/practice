// 엄밀하게 말하면 Binary Search가 아닙니다.
// Binary Search : is a search algorithm that finds the position of a target value within a **sorted array**.
// 정렬이 안된 배열에서 요소의 index를 추출하는 함수.
// O(logN)

public class NotBinarySearch{
    public static int notBinarySearch(int[] arr, int begin, int end, int target) {
        if(begin > end) return -1;
        else {
            int mid = (begin + end) / 2;
            if(target == arr[mid]) return mid;

            int index = notBinarySearch(arr, begin, mid - 1, target);
            if(index != -1) return index;
            else return notBinarySearch(arr, mid + 1, end, target);
        }
    }
}