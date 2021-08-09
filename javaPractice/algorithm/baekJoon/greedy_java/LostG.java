import java.io.*;
import java.util.ArrayList;

// 43 : +  
// 45 : -
// 55-50+40 : equation

class LostG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String equation = br.readLine();
        ArrayList<String> operator = new ArrayList<>(); // collect operators
        ArrayList<Integer> resulted = new ArrayList<>();
        String[] numbers = equation.split("\\+|-"); // collect numbers

        // collect operators
        for(String eq : equation.split("")) {
            if(eq.charAt(0) == 43 || eq.charAt(0) == 45) {
                operator.add(eq);
            } 
        }

        int sum = 0;

        for(int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
            if(i == numbers.length - 1) {
                resulted.add(sum);
                break;
            }
            if(operator.get(i).charAt(0) == 45) {
                resulted.add(sum);
                sum = 0;
            }
        }

        sum = resulted.get(0) * 2;
        for(int s : resulted) {
            sum -= s;
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}