// 18185번 Diamond4
// 아직 안품

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Ramen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOEception {
        int N = Integer.parseInt(br.readLine()); // N : 라면 공장 개수
        int[] A = new int[N + 1]; // A_1, A_2, A_3... A_N
        StringTokenizer st = new StringTokenizer(br.readLine);
        
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int money = 0;
        for(int i = 1; i <= N; i++) {
            if(A[i] == 0) continue; // 첫번째가 0이면 pass
            else { // 중간이 0이면 첫번째x3원 이후 3번째(i+2) 가리키기
                
            }
        }
    }
}