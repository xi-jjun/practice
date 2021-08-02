import java.io.InputStream;

class Fact{
    public static int fact(int n) {
        if(n <= 1) return 1;
        else return n * fact(n-1);
    }
    public static void main(String[] args) throws Exception {
        InputStream is = System.in;
        byte[] datas = new byte[2];
        int N;
        is.read(datas);

        if(datas[1] != 10)
            N = 10*(datas[0] - 48) + (datas[1] - 48);
        else
            N = datas[0] - 48;

        int result = fact(N);
        System.out.println(result);
    }
}