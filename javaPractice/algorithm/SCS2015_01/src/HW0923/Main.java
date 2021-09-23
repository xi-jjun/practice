package HW0923;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));C
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String l : line.split(" ")) numbers.add(Integer.parseInt(l));

        Collections.sort(numbers, Collections.reverseOrder());
        for (Integer num : numbers) bw.write(num + " ");

        bw.flush();
        bw.close();
    }
}
