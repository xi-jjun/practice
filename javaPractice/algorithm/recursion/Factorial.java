public class Factorial {
    public int func(int n) {
        if(n==0) return 1;
        else return n * func(n-1);
    }
}