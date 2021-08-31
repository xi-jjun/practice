class MyArray {
    int[] arr;
    int count;

    public int ARRAY_SIZE;
    public static int ERROR_CODE = -99999999;

    public MyArray() {
        count = 0;
        ARRAY_SIZE = 10;
        arr = new int[ARRAY_SIZE];
    }

    public MyArray(int size) {
        ARRAY_SIZE = size;
        count = 0;
        arr = new int[ARRAY_SIZE];
    }

    public int[] addArray(int element) {

        int[] newArr = new int[ARRAY_SIZE + 1]; // new array

        while(count < ARRAY_SIZE) {
            newArr[count] = arr[count];
            count++;
        }
        newArr[ARRAY_SIZE] = element;
        count = 0;
        ARRAY_SIZE++;
        return newArr;
    }

    public int[] removeArr(int index) {
        int[] newArr = new int[ARRAY_SIZE - 1];

        while(count < ARRAY_SIZE) {
            if(count == index) newArr[count] = arr[++count];
            else newArr[count] = arr[count];
            count++;
        } 
        count = 0;
        ARRAY_SIZE--;
        return newArr;
    }

    public void showArray() {
        System.out.println("START!!");
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\nEND!!");
    }

}