package Kakao;

public class Sol2 {
    static String trans(int n, int k) {

        int nn = n;
        String nnn = "";

        if (k == 10) return Integer.toString(nn);

        while (nn > 0) {
            nnn = (nn % k) + nnn;
            nn /= k;
        }
        return nnn;
    }

    static boolean findPrime(String p) {

//        System.out.println(p.getClass().getSimpleName());
        if(p.equals("")) return false;

        int pp = Integer.parseInt(p);
        if (pp == 1) return false;
        if (pp == 2) return true;

        for (int i = 2; i < Math.sqrt(pp) + 1; i++) {
            if (pp % i == 0) return false;
        }
//        System.out.println(p);
        return true;
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String translated = trans(n, k);

        for (String t : translated.split("0")) {
            if (findPrime(t)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        int ss = solution(n, k);
        System.out.println(ss);
    }
}
