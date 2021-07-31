import java.io.*;

class CAlp{
    public static void main(String[] args) {
        String[] format = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String buff = "";
        int check = 0;
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine(); // ljes=njak
    
            for(String s : line.split("")) {
                buff += s;
                for(String f : format) {
                    if(buff.equals(f)) {
                        buff = "";
                        count++;
                        check = 0;
                    } else if(buff.contains(f)) {
                        buff = buff.replace(f, "");
                        count++;
                        for(int i = 0; i < buff.length(); i++)
                            count++; 
                        buff = "";
                        check = 0;
                    }
                }
                check++;
            }
            if(buff != "") count += buff.length();
            System.out.println(count);

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}