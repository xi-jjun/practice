package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test9_1 {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        ArrayList<Integer> n = new ArrayList<>();

        Arrays.sort(numbers);
        int count = 0;

        for(int i : numbers) {
            if(i == count) {
                count++;
            } else {
                n.add(count);
                count += 2;
            }

        }
    }
}
