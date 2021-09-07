import jdk.nashorn.api.scripting.URLReader;

import java.io.*;

public class Clock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int k = 0; k < N + 1; k++) {
            String hour = k + "";

            for (int i = 0; i < 60; i++) {
                String sec = i + "";

                for (int j = 0; j < 60; j++) {
                    String min = j + "";
                    if (sec.contains("3") || min.contains("3") || hour.contains("3")) {
                        count++;
                    }
                }
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
