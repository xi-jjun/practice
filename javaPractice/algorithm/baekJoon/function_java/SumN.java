// Java: long sum(int[] a); (클래스 이름: Test)
// a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
// 리턴값: a에 포함되어 있는 정수 n개의 합

class SumN{
    public static long sum(int[] a) {
        long sum = 0;
        for(int i : a)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int[] datas = {1,4,6,354,17,90,8};
        System.out.println(sum(datas));
    }
}