package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i : data) System.out.print(i + " ");

        for (int i = 1; i < data.length; i++) {

            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
                else break;
            }
        }

        System.out.println("");
        for (int i : data) System.out.print(i + " ");
    }
}
