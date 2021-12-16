import java.util.*;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String info = "[콜라,1500,20]";//;[사이다,1000,10]";
		String[] infos = {
				"[콜라,1500,20]",
				"[콜1라,1500,20]",
				"[콜1라11,1500,20]",
				"[콜1라ASD1fk2,1500,20]",
				"[12콜we1라,1500,20]",
				"[qwe12콜we1라,1500,20,qwe12콜we1라,1500,20]",
				"[qwe12콜we1라,1500,20],[qwe12콜we1라,1500,20]",
				"[qwe12콜we1라,a1500,20]",
				"[qwe12콜we1라,1a500,20]",
				"[qwe12콜we1라,1500,2r0]",
				"[콜라,1500000000000000,20]",
				"[콜라,1500,200000000000000000]",
				"[콜라라라라라라랄라라라라라라라라라라랄라라라라라라라라라라라랄라라라라라라라라라라라라라라라라ㅏㄹ라라라,1500,200]",
				"[콜라라라라라라랄라라라라라라라라라라랄라라라라라라라라라라라랄라라라라라라라라라라라라라라라라라라라,1500,200]",
				"[,1500,20]",
				"콜라,1500,20]",
				"[콜라,1500,20",
				"[콜라,1500,20,10]",
				"[콜라,,20]",
				"[콜라,1500,]",
				"[콜라,,]",
				"[콜라,]",
				"[,,]",
				"[,,,]",
				"[콜라,1500,20]]",
				"[[콜라,1500,20]",
				"[[[콜라,1500,20]",
				"[[[]]]",
				"[][[]]]",
				"[콜라,1,20]]",
				"[콜라,150020]]",
				"[콜라1500,20]]"
		};
		String checker = "(^\\[)([가-힣a-zA-Z0-9]{1,10}),(\\d{2,10}),(\\d{1,10})(\\]$)";
		for (String i : infos) {
			System.out.println(i+" : "+Pattern.matches(checker, i));
		}
//		boolean regex = Pattern.matches("^\\[\\S+{1,20}\\,*\\d{2,10}\\,*\\d{1,10}\\]$", info);
//		String info2 = "123111";
//		boolean regex2 = Pattern.matches("^\\d{0,6}", info2); // 숫자만 통과
//
//		System.out.println("regex = " + regex);
//		System.out.println("regex2 = " + regex2);
	}

}
