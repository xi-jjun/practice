package HW1202;

public class Main {
	public static void main(String[] args) {
		System.out.println("ArrList<E> 클래스 설계");
		ArrList<Integer> arr = new ArrList<>();
		arr.add(5);
		arr.add(4);
		arr.add(-1);

		System.out.println("ArrList 요소수: " + arr.size());
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println("");

		arr.add(2, 100);
		arr.show();

		arr.remove(1);
		arr.show();
	}
}
