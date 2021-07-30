import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Average{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            double avg = 0;
            double sum = 0;
            ArrayList<Double> subjects = new ArrayList<>(); // grades
            int N = Integer.parseInt(br.readLine()); // 과목 수 

            String line2 = br.readLine();
            StringTokenizer st = new StringTokenizer(line2);
            for(int i = 0; i < N; i++) 
                subjects.add(Double.parseDouble(st.nextToken())); 
            
            double M = Collections.max(subjects); // get Maximun value of subjects ArrayList

            // 점수/M *100
            for(int i = 0; i < N; i++) 
                subjects.set(i, (subjects.get(i)/M) * 100);

            for(double i : subjects)
                sum += i;

            avg = sum / N;
            bw.write(avg + "");
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }
}