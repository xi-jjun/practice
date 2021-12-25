package finalTest;

public class Main {
	public static void main(String[] args) {
		// 2번 문제 Main
		TV lg = new TV(7);
		System.out.println("현재 채널은 " + lg.get_channel() + "번");

		// 3번 문제 Main
		AI_TV siri = new AI_TV("시리야", 7);
		siri.command("시리야");
		siri.command("누구");
	}
}
