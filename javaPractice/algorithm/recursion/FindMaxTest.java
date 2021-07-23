public class FindMaxTest{
    public static void main(String[] args) {
        int[] data = {3,5,5,2,6,24,7,6,624,8,75,7,85,7,4,657,53,463,6,53,6,342,776,57,8,99,7,7,8,5488,685,87,8,76,8,678,1023,656,4,64,888,72,73,5,100};
        System.out.println(FindMax.findMax(data, 0, data.length - 1));
        System.out.println(FindMax.findMax2(data, 0, data.length - 1));
    }
}