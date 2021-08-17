// 1439번 silver5

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Reverse{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int count0 = 0, count1 = 0;
        String prev = "";

        for(String c : S.split("")) {
            if(c.equals("0")) {
                count0 = prev.equals("0") ? count0 : ++count0;
            } else {
                count1 = prev.equals("1") ? count1 : ++count1;
            }
            prev = c;
        }
        int result = count1 >= count0 ? count0 : count1;
        bw.write(result + "");

        bw.flush();
        bw.close();
    }
}