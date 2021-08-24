public class EqualTest {

	public static void main(String[] args) {
		Student Lee = new Student(100, "Lee");
		Student Lee2 = Lee;
		Student Shun = new Student(100, "Lee");
		
		// System.out.println(Lee == Shun);
		// System.out.println(Lee.equals(Shun));
		
		// System.out.println(Lee.hashCode());
		// System.out.println(Shun.hashCode());

		String str1 = new String("abc");
		String str2 = "abc";
		String str3 = new String("abc");
		String str4 = "abc";

		Student sd1 = new Student(100, "Kim");
		Student sd2 = new Student(100, "Kim");
		Student sd3 = new Student(100, "Kim");
		Student sd4 = new Student(100, "Kim");
		Student sd5 = sd1;
		System.out.println(sd5.equals(sd1));
		System.out.println("");

		System.out.println(sd1.hashCode()); // BBB
		System.out.println(sd2.hashCode()); // BBB
		System.out.println(sd3.hashCode()); // XXX
		System.out.println(sd4.hashCode()); // XXX
		System.out.println(sd5.hashCode()); // XXX

		System.out.println("");

		System.out.println(System.identityHashCode(sd1));
		System.out.println(System.identityHashCode(sd2));
		System.out.println(System.identityHashCode(sd3));
		System.out.println(System.identityHashCode(sd4));
		System.out.println(System.identityHashCode(sd5));

		System.out.println("");

		System.out.println(sd1);
		System.out.println(sd2);
		System.out.println(sd3);
		System.out.println(sd4);
		System.out.println(sd5);
		
		
		// Integer i1 = new Integer(100);
		// Integer i2 = new Integer(100);
		
		// System.out.println(i1.equals(i2));
		// System.out.println(i1.hashCode());
		// System.out.println(i2.hashCode());
		
		// System.out.println(System.identityHashCode(i1));
		// System.out.println(System.identityHashCode(i2));

	}
}
