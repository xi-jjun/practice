import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;

class OverAvg{
    // 5 test case C
    // 5 50 50 70 80 100
    // 7 100 95 90 80 70 60 50
    // 3 70 90 80
    // 3 70 90 81
    // 9 100 99 98 97 96 95 94 93 91
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            double avg = 0;
            double sum = 0;
            double result;
            double rate = 0;
            int C = Integer.parseInt(br.readLine()); // Test case C

            for(int i = 0; i < C; i++) {
                String lines = br.readLine();
                StringTokenizer st = new StringTokenizer(lines);
                int N = Integer.parseInt(st.nextToken());
                double[] grades = new double[N];

                for(int j = 0; j < N; j++) {
                    grades[j] = Double.parseDouble(st.nextToken());
                    sum += grades[j];
                }
                avg = sum / N;

                for(int k = 0; k < N; k++)
                    if(grades[k] > avg) rate += 1;

                rate /= N;
                bw.write(String.format("%.3f", rate*100) + "%\n");
                sum = 0;
                rate = 0;
            }

            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }
}