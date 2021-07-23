// String 문자열 길이
public class StringLength {
    public static int stringLen(String str) {
        if(str.equals("")) return 0;
        else return 1 + stringLen(str.substring(1));
    }
}