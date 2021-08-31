import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class ArrayTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int SIZE = Integer.parseInt(br.readLine());
        MyArray arr = new MyArray(5);
        arr.showArray();
        arr.addArray(10);
        arr.showArray();
        arr.removeArr(5);
        arr.showArray();
    }
}