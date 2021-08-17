// 13305 baekJoon silver4
// 17점

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

// #include<stdio.h>

// int p[101000];
// int s;
// int main()
// {
// 	int x, cnt = 0, mx = 200000000;
// 	scanf("%d",&x);
// 	x--;
// 	for(int i = 0; i < x; i++)
// 	    scanf("%d",&p[i]);
// 	for(int i = 0; i < x; i++) {
// 		scanf("%d",&s);
// 		mx = mx > s ? s : mx;
// 		cnt += mx*p[i];
//     }
//     printf("%d",cnt);
// }

class GasStation{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Long> cityLen = new ArrayList<>();
        ArrayList<Long> price = new ArrayList<>();
        long[] buffer = new long[100001]; // cityLen buffer
        int temp = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // length of cities
        for(int i = 0; i < N-1; i++) {
            cityLen.add(Long.parseLong(st.nextToken()));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        // gas price
        for(int i = 0; i < N; i++) {
            price.add(Long.parseLong(st2.nextToken()));
        }

        long result = 0;
        long nowPrice = 0;
        long nextPrice = 0;
        long nowLen = 0;

        int index = 0;
        long min = price.get(0);

        for(int i = 0; i < N-1; i++) {
            nowPrice = price.get(i);
            nextPrice = price.get(i+1);

            nowLen = cityLen.get(i);

            // if(i == N-2) result += min * nowLen;
            if(min > nextPrice || i == N-2) {
                if(buffer[0] != 0) {
                    for(long k : buffer) {
                        if(k == 0) break;
                        result += min*k;
                    }
                    result += min*nowLen;
                    buffer[0] = 0;
                    index = 0;
                    
                } else {
                    // if(i != N-2)
                    result += min*nowLen;
                }
                min = nextPrice;
            } else {
                // min = nowPrice;
                buffer[index] = nowLen;
                index++;
            }
            // bw.write("Result "+i+" : "+result + "\n");
        }

        bw.write(result + " ");

        bw.flush();
        bw.close();
    }
}