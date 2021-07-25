public class BinarySearchTest{
    public static void main(String[] args) {
        String[] datas = {"aa", "bb", "cc", "dd", "ee", "ff", "gg"};
        System.out.println(datas.length);
        System.out.println(BinarySearch.binarySearch(datas, "aa", 0, datas.length - 1));
    }
}