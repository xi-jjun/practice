package sort;

import java.util.ArrayList;
import java.util.List;

public class Lv2 {
    public static String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Mapper> number = new ArrayList<>();

        for (int j : numbers) number.add(new Mapper(j + ""));

        number.sort((o1, o2) -> o2.sortValue - o1.sortValue);

        for (Mapper mapper : number) {
            sb.append(mapper.original);
        }

        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
//        int[] numbers = new int[]{3, 30, 34, 5, 9};
        int[] numbers = new int[]{6, 10 ,2};
//        int[] numbers = new int[]{0, 0, 0, 1, 0};
//        int[] numbers = new int[]{1000, 100};
        System.out.println("solution(numbers) = " + solution(numbers));
    }

    static class Mapper {
        String original;
        Integer sortValue;

        public Mapper(String original) {
            this.original = original;
            StringBuilder temp = new StringBuilder(original);
            while (temp.length() <= 4) {
                temp.append(original);
            }
            if(temp.length() != 5) temp.delete(5, temp.length());
            System.out.println("temp = " + temp);
            this.sortValue = Integer.parseInt(String.valueOf(temp));
        }
    }
}
