import java.io.*;

class WordChecker{
    public static void main(String[] args) {
        int[] checker = new int[123];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); 
            int index = 0;
            String line;
            boolean flag = true;
            int[] check = new int[2];
            int count = 0;

            for(int i = 0; i < N; i++) {
                line = br.readLine();

                for(String s : line.split("")) {
                    check[0] = index;
                    index = (int)s.charAt(0);
                    check[1] = index;
                    checker[index]++;
                    if(checker[index] >= 2 && check[0] != check[1]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
                flag = true;
                index = 0;
                for(int j = 97; j <= 122; j++) checker[j] = 0;
            }
            System.out.println(count);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}