package HW1202;

public class ArrList<E> {
	private E[] a;
	private int size;

	ArrList() {
		a = (E[]) new Object[50];
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		return a[index];
	}

	public void add(E item) {
		a[size] = item;
		size++;
	}

	public void add(int index, E item) {
		for (int i = size; i > index; i--) {
			a[i] = a[i - 1];
		}
		a[index] = item;
		size++;
	}

	public void remove(int index) {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		while (index++ != size - 1) {
			a[index - 1] = a[index];
		}
		size--;
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
}
