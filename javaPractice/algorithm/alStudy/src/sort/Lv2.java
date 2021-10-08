package sort;

import java.util.ArrayList;
import java.util.List;

public class Lv2 {
    public static String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<String> number = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) number.add(numbers[i] + "");

        number.sort((o1, o2) -> {
            if(o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++)
                    if (o1.charAt(i) != o2.charAt(i)) return o2.charAt(i) - o1.charAt(i);
            } else {
                for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) return o2.charAt(i) - o1.charAt(i);
                    else return o1.length() - o2.length();
                }
            }
            return o2.charAt(0);
        });
        for (String s : number) {
            System.out.println(s);
        }
        for (String num : number) sb.append(num);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};
        System.out.println("solution(numbers) = " + solution(numbers));
    }
}
