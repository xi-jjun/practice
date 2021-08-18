// 1339 baekJoon Gold4
// 못풀었다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.lang.Math;

class WordMath{
    // seq 1 : max, seq 2 : max-1...
    static int[] findMax(int[] countArray, int seq) {
        int j = 1, k = 0;
        int[] index = new int[10];
        int[] re = new int[27];

        for(int i = 65; i < 91; i++) {
            re[j++] = countArray[i];
        }
        
        Arrays.sort(re);

        int diff = re[27 - seq];

        for(int i = 65; i < 91; i++) {
            if(diff == 0) {
                break;
            }
            if(diff == countArray[i]) {
                index[k++] = i;
            }
        }

        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine()); // 1<= N <= 10
        String[][] alpha = new String[N][9]; 
        int[] count = new int[91]; // alpha count. 각 문자열의 요소 하나하나를 저장하는 배열.
        int[] len = new int[10]; // 각 문자열 길이를 저장하는 배열 

        for(int i = 0; i < N; i++) {
            String word = br.readLine(); // ABC
            int strLen = word.length();
            len[i] = strLen;

            for(String s : word.split("")) {
                int index = s.charAt(0);
                count[index] += Math.pow(10, strLen); // 해당 문자(index)의 가중치
                alpha[i][strLen--] = s; // A , B , C

            }
        }

        int[] indexs = new int[10];
        int[] result = new int[91];
        int k = 0;

        for(int i = 1; i <= 9; i++) {
            indexs = findMax(count, i); // 1번째로 큰수, 2번째로 큰수...i번째로 큰수 구해주는 함수. 결과는 배열.
            k = i;
            for(int j : indexs) {
                result[j] = 10 - k--;
                if(10 - k < 0 || 10 - k > 9) break;
            }
        }

        int[] numbers = new int[10]; // 문자열을 숫자로 바꿔준 결과를 저장할 배열.
        
        int i = 0, j = 0;
        for(String[] s : alpha) {
            j = len[i];
            for(String ss : s) {
                if(ss != null) {
                    // 문자열에 해당하는 숫자 += 각 문자에 해당하는 자연수 * 자릿수 
                    numbers[i] += result[ss.charAt(0)] * Math.pow(10, len[i]-j);
                    j--;
                }          
            }
            i++;
        }

        int sum = 0;

        for(int sss : numbers) {
            sum += sss;
        }
        bw.write(sum +"");

        bw.flush();
        bw.close();
    }
}