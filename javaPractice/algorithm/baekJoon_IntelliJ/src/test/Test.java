package test;

import java.util.*;

public class Test {
	static List<Integer> a = Arrays.asList(1, 2, 3, 5);
	public static void main(String[] args) {
		List<List<Integer>> recentOutputs = new ArrayList<>();
		List<List<Integer>> aaa = new ArrayList<>();

		List<Integer> b = Arrays.asList(1, 2, 3, 5);
		List<Integer> c = Arrays.asList(1, 2, 4, 4);
		List<Integer> d = Arrays.asList(1, 2, 4, 4);
		List<Integer> e = Arrays.asList(2, 2);
		List<Integer> f = Arrays.asList(2, 1);

		List<Integer> ooo = Arrays.asList(1, 2);
		aaa.add(e);
		aaa.add(f);
		boolean b2 = aaa.stream().anyMatch(ll -> ll.equals(ooo));
		System.out.println("b2 = " + b2);

		List<Integer> output = Arrays.asList(1, 2, 3, 4);
		recentOutputs.add(a);
		recentOutputs.add(a);
		recentOutputs.add(a);
		recentOutputs.add(b);
		recentOutputs.add(c);
		recentOutputs.add(d);
		for (List<Integer> recentOutput : recentOutputs) {
			for (Integer out : recentOutput) {
				System.out.print(out+" ");
			}
			System.out.println();
		}
		System.out.println("===");
		a = Arrays.asList(0, 0);
		for (List<Integer> recentOutput : recentOutputs) {
			for (Integer out : recentOutput) {
				System.out.print(out+" ");
			}
			System.out.println();
		}
		System.out.println(recentOutputs.size());

		boolean b1 = recentOutputs.stream()
				.anyMatch(list -> list.equals(output));
		System.out.println(b1);
	}

}
