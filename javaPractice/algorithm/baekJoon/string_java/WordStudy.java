import java.io.InputStream;

public class WordStudy {
    public static void main(String[] args) throws Exception {
        InputStream is = System.in;
        int[] count = new int[123];
        byte[] datas = new byte[1000001];
        int index = 0; // ASCII code of char
        char c;
        int max = 0;
        char result;
        int check = 0;

        int w = is.read(datas);
        String word = new String(datas, 0, w-1);
        word = word.toLowerCase(); // make lower case

        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i); // get char in word(Str)
            index = (int)c; // char to int : ASCII
            count[index]++;
        }

        for(int i = 97; i <= 122; i++) {
            if(count[i] > max) {
                max = count[i];
                index = i; // index : most frequently char's index
                check = 0;
            } else if(count[i] == max && count[i] != 0) {
                check++;
            }
        }
        if(check >= 1) {
            System.out.println("?");
            return;
        }
        result = (char)index;
        result = Character.toUpperCase(result);
        System.out.println(result);
    }
}