// 15649 silver3
// 모르겠다...

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class N_M1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int count = 0;
    
    // static void NM(int[] arr, int N, int M) throws IOException {
    //     for(int i = 0; i < N; i++) {
    //         bw.write(arr[i] + " ");

    //         for(int j = 0; j < M; j++) {
    //             if(arr[j] == i + 1) continue;
    //             else {
    //                 count++;
    //                 if(count > 10) return;
    //                 NM(arr, N, M);
    //             }
    //         }
    //         bw.write("\n");
    //     }
    // }

    static int times(int o_N, int N, int M, int time) {
        if(time == M) return o_N-M+1;
        else return N * times(o_N, N-1, M, ++time);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = i+1;
        }

        // NM(nums, N, M);
        // bw.write(times(N, N, M, 1)+"");
        int time = times(N, N, M, 1);
        for(int k = 0; k < time; k++) {
            for(int i = 0; i < N; i++) {
                bw.write(nums[i] + " ");
    
                for(int j = 0; j < M; j++) {
                    if(nums[j] == i + 1) continue;
                    else bw.write(nums[j] + " ");
                }
                bw.write("\n");
            }
        }

        

        bw.flush();
        bw.close();
    }
}