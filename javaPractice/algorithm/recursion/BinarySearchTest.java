public class BinarySearchTest{
    public static void main(String[] args) {
        String[] datas = {"fkef", "ggrni", "sjgkkb", "wkfe", "jkfgg", "KJJ", "nk34f"};
        System.out.println(datas.length);
        System.out.println(BinarySearch.binarySearch(datas, "ggrni", 0, datas.length - 1));
    }
}