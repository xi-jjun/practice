// 2021.07.22 Java 문자열 거꾸로 출력하기

public class ReverseString {
    public static void reversePrintStr(String str) {
        if(str.length() == 0) return;
        else {
            reversePrintStr(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    public static String reverseString(String str) {
        StringBuffer sb = new StringBuffer(str); 
        String reversedStr = sb.reverse().toString();

        return reversedStr;
    }
}