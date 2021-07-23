//두 수의 최대 공약수 구하기
public class Gcd {
    public static double gcd(int num1, int num2) {
        if(num1 < num2) {
            int swap = num1;
            num1 = num2;
            num2 = swap;
        } 
        
        if(num1 % num2 == 0) return num2;
        else return gcd(num2, num1 % num2);
    }
}