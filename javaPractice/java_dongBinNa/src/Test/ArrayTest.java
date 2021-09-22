package Test;

public class ArrayTest {
    static class Student {
        String name;
        int studentId;

        Student(String name, int studentId) {
            this.name = name;
            this.studentId = studentId;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Student[] arr2 = new Student[4];
        arr2[0] = new Student("First", 111);
        arr2[1] = new Student("Second", 222);
        arr2[2] = new Student("Third", 333);
        arr2[3] = new Student("4th", 444);

        System.out.println(System.identityHashCode(arr[0]));
        System.out.println(System.identityHashCode(arr[1]));
        System.out.println(System.identityHashCode(arr[2]));
        System.out.println(System.identityHashCode(arr[3]));

        System.out.println("");

        System.out.println(System.identityHashCode(arr2[0]));
        System.out.println(System.identityHashCode(arr2[1]));
        System.out.println(System.identityHashCode(arr2[2]));
        System.out.println(System.identityHashCode(arr2[3]));
    }
}
