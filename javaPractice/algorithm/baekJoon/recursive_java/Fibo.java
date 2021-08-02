import java.io.InputStream;

class Fibo{
    public static int fibo(int n) {
        if(n == 0) return 0;
        else if(n <= 2) return 1;
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    public static void main(String[] args) throws Exception {
        InputStream is = System.in;
        byte[] datas = new byte[2];
        int n;
        is.read(datas);

        if(datas[1] != 10)
            n = 10*(datas[0] - 48) + (datas[1] - 48);
        else
            n = datas[0] - 48;

        int result = fibo(n);
        System.out.println(result);
    }
}