import java.util.Scanner;

class Dial{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] phone = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"}; // 2~9

        String number = scan.next(); // input
        int index = 0;
        int time = 0;

        for(String c : number.split("")) {
            for(String dial : phone) {
                if(dial.contains(c)) break;
                index++;
            }
            time += index + 3;
            index = 0;
        }
        System.out.println(time);
    }
}