public class NotBinarySearchTest{
    public static void main(String[] args) {
        int[] data = {1,5,3,7,8,9,2,4,14,52,16,85,66,78,12,555,64,25,74};

        System.out.println(NotBinarySearch.notBinarySearch(data, 0, data.length - 1, 66));
    }
}