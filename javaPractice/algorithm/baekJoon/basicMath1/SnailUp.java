// 조건 : 0.15 제한 2869번 문제
import java.io.*;
import java.util.StringTokenizer;

class SnailUp{

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            long days = 0;
            long A, B, V;
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());
            V = Long.parseLong(st.nextToken());

            long compare = (V-B) % (A-B);
            days = (V-B) / (A-B);

            if(compare != 0) days++;
            bw.write(days + "\n");
            
            // time checker
            long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
            long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산

            bw.write(secDiffTime + "\n");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }
}