public class Power {
    public static int func(int number, int exponent) {
        if(exponent == 0) return 1;
        else return number * func(number, exponent - 1);
    }
}