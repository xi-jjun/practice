package finalTest;

public class Practice {
	public static void main(String[] args) {
		Practice ex = new Practice();
		ex.random3(7);

		// 1-(2)
		ex.div10(2973);

		// 1-(3)
		System.out.println(lower('H'));

		// 1-(4)
		ex.last_word("What's your name?");
		ex.last_word("I am a boy");

		// 1-(5)
		ex.max_no(18670725);
		ex.max_no(20030615);
	}
	public static char lower(char h) {
		return (char) (h + 32);
	}

	public static void max_no(int number) {
		int max = -1;
		while ((number/=10) != 0) {
			int num = number % 10;
			max = Math.max(num, max);
		}
		System.out.println(max);
	}

	public static void last_word(String input) {
		String[] words = input.split(" ");
		System.out.println(words[words.length - 1]);
	}

	public static void random3(int i) {
		for (int j = 0; j < i; j++) {
			int rand = (int) (Math.random() * 100 + 1);
			if (rand % 3 == 0) {
				System.out.print(rand + " ");
			} else j--;
		}
	}

	public void div10(int i) {
		System.out.println(i % 10);
	}
}
