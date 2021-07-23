public class wak{
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Hi";
        System.out.println("변경 전 str1(Hello literal)->" + System.identityHashCode(str1));

        String str4 = new String("Hello");
        String str5 = new String("Hello");
        str1 = str1 + " World!";

        String str6 = "Hello World!";
        
        System.out.println("변경 후 str1(Hello World literal)->" + System.identityHashCode(str1));
        System.out.println("str2(Hello literal)->" + System.identityHashCode(str2));
        System.out.println("str3(Hi)->" + System.identityHashCode(str3));
        System.out.println("str4(Hello new)->" + System.identityHashCode(str4));
        System.out.println("str5(Hello new)->" + System.identityHashCode(str5));       
        System.out.println("str6(Hello World literal)->" + System.identityHashCode(str6));       
    }
}