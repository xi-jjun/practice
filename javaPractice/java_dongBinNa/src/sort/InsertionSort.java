package sort;

public class InsertionSort {
	static final int SIZE = 10;

	static void generateData(int[] ins, int[] sys) {
		for (int i = 0; i < SIZE; i++) {
			double value = Math.random();
			ins[i] = (int) (value * SIZE);
			sys[i] = (int) (value * SIZE);
		}
	}

	public static void main(String[] args) {
		int[] ins, sys;
		ins = new int[SIZE]; // Insertion Sort TEST
		sys = new int[SIZE]; // System function TEST

		long startTime, endTime;
//        generateData(ins, sys); // random array generate
		ins = new int[]{79, 14, 32, 7, 18, 9, 37, 28};
		for (int n : ins) System.out.print(n + " ");
		System.out.println("");
		startTime = System.currentTimeMillis(); // START!!
		for (int i = 1; i < ins.length; i++) {
			for (int k = i - 1; k >= 0; k--) {
				if (ins[i] < ins[k]) {
					int temp = ins[i];
					ins[i] = ins[k];
					ins[k] = temp;
					i--;
				} else break;
			}
			for (int n : ins) System.out.print(n + " ");
			System.out.println("");
		}
		for (int n : ins) System.out.print(n + " ");

		endTime = System.currentTimeMillis(); // END!!


	}
}
