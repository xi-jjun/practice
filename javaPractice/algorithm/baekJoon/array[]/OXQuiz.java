// baekJoon 8958

import java.io.*;
import java.util.ArrayList;

class OXQuiz{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int count;
            int countSum;

            ArrayList<String> answers = new ArrayList<>(); // OX String
            int T = Integer.parseInt(br.readLine()); // number of Test Case 

            for(int i = 0; i < T; i++) 
                answers.add(br.readLine()); // OXOOXXOXO

            for(String answer : answers) {
                count = 0;
                countSum = 0;

                for(int i = 0; i < answer.length(); i++) {
                    if(answer.charAt(i) == 'O') {
                        count++;
                        countSum += count;
                    } else {
                        count = 0;
                        countSum += count;
                    }
                }
                bw.write(countSum + "\n");
            }

            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }
}