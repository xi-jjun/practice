package Kakao;

import java.util.ArrayList;

public class Sol3 {
    static int[] carNumber = new int[10000]; // In Out count
    static int[][] carTime = new int[10000][1000]; // [CarNum] : time1 time2 time3..

    public static int[] solution(int[] fees, String[] records) {
        int[] answer;

        for (String record : records) {
            String[] re = record.split(" ");
            String time = re[0];
            int carNum = Integer.parseInt(re[1]);
            String InOut = re[2];

            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int min = Integer.parseInt(t[1]);
            carTime[carNum][carNumber[carNum]] = h * 60 + min;
            carNumber[carNum]++;
        }

        ArrayList<Integer> cars = new ArrayList<>();

        for (int i = 0; i < carNumber.length; i++) {
            if (carNumber[i] != 0) {
                cars.add(i);
            }
        }

        answer = new int[cars.size()];
        int cc = 0;
        for (int c : cars) {
            int[] tt = carTime[c];
//            for(int t : tt) System.out.println(t);
            int idx = 0;
            int sum = 0;
            while (tt[idx] != 0 || idx == 0) {
                if (tt[2 * idx + 1] != 0) {
                    sum += tt[2 * idx + 1] - tt[2 * idx];
                    if (tt[2 * idx + 2] == 0) break;
                } else {
                    sum += (60 * 23 + 59) - tt[2 * idx];
                    break;
                }
                idx++;// 360 394 1139 : sum = 34 + 300
            }
            int f;
            if (sum > fees[0]) {
                int a = (sum - fees[0]) % fees[2] != 0 ? (sum - fees[0]) / fees[2] + 1 : (sum - fees[0]) / fees[2];
                f = fees[1] + (a * fees[3]);
            } else {
                f = fees[1];
            }
            answer[cc++] = f;
        }
//        for (int c : cars) System.out.print(c + " ");
//        for (int a : answer) System.out.println(a);

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        System.out.println(Integer.parseInt("00"));
        System.out.println(solution(fees, records)[0]);
    }
}
