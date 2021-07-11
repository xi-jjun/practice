// 프로그래머스 데브 코스 코테 2021 07 11 문제1
class Solution1 {
    public static int solution1(int[] d, int m) {
        int answer = 0;
        int sendNum = 1;

        for(int i : d) {
            if(m <= 0) break;

            if(i >= sendNum) {
                m -= sendNum;
                sendNum *= 2;
            } else {
                sendNum = 1;
            }
            answer++;
        }

        if(m > 0) {
            answer = -1;
        }

        return answer;
    }

    // 로컬에서 실행을 위해 추가 작성한 코드
    public static void main(String[] args) {
        int answer;
        int[] d = {1,3,2,5,4};
        int m = 6;

        answer = solution1(d, m);
        System.out.println(answer);
    }
}