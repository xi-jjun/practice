package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
		String answer = "hello";
		List<String> currentTriedAnswers = new ArrayList<>();
		currentTriedAnswers.add("a");
		currentTriedAnswers.add("b");
		currentTriedAnswers.add("e");
		currentTriedAnswers.add("hero");

		List<String> state = new ArrayList<>();
		for (String ans : answer.split("")) {
			if (currentTriedAnswers.stream().anyMatch(curAns -> curAns.equals(ans))) {
				state.add(ans);
			} else {
				state.add("_");
			}
		}

		state.forEach(System.out::print); // print → _e___


		// === stream === //

	}
}
