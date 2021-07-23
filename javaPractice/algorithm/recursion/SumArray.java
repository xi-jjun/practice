// 배열의 합
public class SumArray{
    public static int sumArr(int index, int[] arr) {
        if(index <= 0) return 0;
        else return sumArr(index - 1, arr) + arr[index - 1];
    }
}