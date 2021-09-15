package Kakao;

import java.io.*;
import java.util.ArrayList;

public class Sol1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static int[] solution(String[] id_list, String[] report, int k) throws IOException {
        int[] answer = new int[id_list.length];
        int[] getSinGo = new int[id_list.length];
        int[] getMsg = new int[id_list.length];
        ArrayList<ArrayList<Integer>> id = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < id_list.length; i++) id.add(new ArrayList<Integer>());

        for (String r : report) {
            String[] rr = r.split(" ");
            String reporter = rr[0]; // 신고자
            String reported = rr[1]; // 신고당한 id
            int reporterIndex = 0;
            int reportedIndex = 0;
            boolean a = false;
            boolean b = false;

            for (int i = 0; i < id_list.length; i++) {

                if (id_list[i].equals(rr[0])) {
                    a = true;
                    reporterIndex = i;
                }
                if (id_list[i].equals(rr[1])) {
                    b = true;
                    reportedIndex = i;
                }
                if (a && b) break;
            }
            id.get(reporterIndex).add(reportedIndex);
            getSinGo[reportedIndex]++;
        }
        int idx=0;
        for (ArrayList<Integer> ii : id) {
            for (Integer iii : ii) {
                if (getSinGo[iii] >= k) answer[idx]++;
            }
            idx++;
        }

//        for (int i = 0; i < getSinGo.length; i++) {
//            if (getSinGo[i] >= k) {
//                for (ArrayList<Integer> ii : id) {
//                    for (Integer iii : ii) {
//                        if (iii == i) {
//                            answer[iii]++;
//                            bw.write(i + " " + ii + " " + iii + "!!\n");
//
//                        } else bw.write(i + " " + ii + " " + iii + "\n");
//                    }
//                }
//            }
//        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] a = new int[id_list.length];

        a = solution(id_list, report, k);

        for (int i : a) bw.write(i + " ");

        bw.flush();
        bw.close();

    }
}

