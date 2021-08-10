class PrintNull{
    public static void main(String[] args) {
        int[] intArray1;
        int[] intArray2 = new int[5];

        for(int i : intArray1)
            System.out.println(i);
        for(int i : intArray2)
            System.out.println(i);
    }
}