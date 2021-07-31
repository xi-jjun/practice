import java.io.*;

class FindBunSu{

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int x, y, n = 1;
            int index;
            int T = Integer.parseInt(br.readLine()); // X

            while(((n*(n-1))/2 < T && T <= (n*(n+1))/2) != true) n++;
            
            if(n%2 == 1) {
                index = (n*(n+1))/2 - T;
                x = index;
                y = n - 1 - index;
            } else {
                index = T - ((n*(n-1))/2 + 1);
                x = index;
                y = n - 1 - index;
            }
            System.out.println((x+1) + "/" + (y+1));
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}