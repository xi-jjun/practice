package Test;

public class ArrayTest {

    public static void main(String[] args) {
        String hi = "hi";
        String hi2 = new String("hi");

        if(hi == "hi"){
            System.out.println("두 문자열이 동일 합니다.");
            System.out.println(System.identityHashCode(hi) + " " + System.identityHashCode("hi") + " " + System.identityHashCode(hi2));
        }else{
            System.out.println("두 문자열이 다릅니다.");
        }
    }
}
