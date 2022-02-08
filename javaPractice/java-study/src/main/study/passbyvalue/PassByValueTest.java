package main.study.passbyvalue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PassByValueTest {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void swap(int a, int b) throws IOException {
		bw.write("\nBefore executing in swap Function a = "+a);
		bw.write("\nBefore executing in swap Function b = "+b);

		a = a + b;
		b = a - b;
		a = a - b;

		bw.write("\n\nAfter executing in swap Function a = "+a);
		bw.write("\nAfter executing in swap Function b = "+b);
	}

	public static void main(String[] args) throws IOException {
		// pass by value test
		int a = 10;
		int b = 20;
		bw.write("first a = " + a);
		bw.write("\nfirst b = " + b);

		swap(a, b);

		/**
		 * a, b 가 swap 이후에도 원래의 값을 유지한다 → pass by value
		 *
		 * 실제로 Java Language Specification의 (Section 4.3) 에서는 원시 값이든 객체든 상관없이 모든 데이터를 Pass By Value로 전달한다고 나와 있다.
		 * 출처: https://mangkyu.tistory.com/107 [MangKyu's Diary]
		 * Java에서는 객체에 한해 확장된 규칙이 적용된다. 그것은 개체와 관련되어 복사 후 전달되는 값은 실제 메모리를 가리키는 Reference(참조값)인 포인터라는 것
		 * 출처: https://mangkyu.tistory.com/107 [MangKyu's Diary]
		 */
		bw.write("\n\nAfter came out from swap function a = " + a);
		bw.write("\nAfter came out from swap function b = " + b);


		bw.write("\n\n=== === === === === === === === === === === === ===\n");
		bw.write("=== === === === Object Test === === === ===");

		Foo foo = new Foo(10);
		bw.write("First foo value = " + foo.value + "\n");

		process(foo);

		bw.write("Last foo value = " + foo.value + "\n");

		bw.flush();
		bw.close();
	}

	private static void process(Foo paramFoo) {
		paramFoo.setValue(50);

		/**
		 * Java 는 call by value 방식이기 때문에 Parameter 로 들어오는 객체는 모두
		 * 원본 객체의 복사된 주소값을 가리키고 있다.
		 * 따라서!! 아래의 상황을 가정해보자.
		 * 원본 foo 객체 주소 : 0x1111
		 * foo 변수의 값 : 0x1111
		 * foo 변수의 주소 : 0x1234
		 *
		 * process 함수의 Stack...
		 * 현재 process 라는 함수로 전달된 paramFoo 는
		 * paramFoo 값 : 0x1111(원본 foo 객체 주소)
		 * paramFoo 주소 : 0x5555
		 * ... Stack!!
		 *
		 * 따라서 paramFoo 를 아래와 같이
		 * paramFoo = new Foo(9999);
		 * 로 바꿔도, 새롭게 생긴 new Foo(9999) 에 대한 주소를 자기자신의 값으로 바꿀 뿐이다.
		 * 구체적으로 말하자면, new Foo(9999) 주소가 0x9999라고 한다면,
		 * paramFoo 의 값 : 0x9999 로 변경!!
		 * → 결국 원래 foo 객체는 여전히 0x1111에 잘 있고, 영향을 받지 않았다.
		 * !!!! 결론 !!!!
		 * 따라서 Java 는 Pass by value 라는 것!!!
		 */

		paramFoo = new Foo(9999);
	}

	static class Foo {
		int value;
		FooFoo fooFoo;

		public Foo(int value) {
			this.value = value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	static class FooFoo{
		String value;

		public FooFoo(String value) {
			this.value = value;
		}
	}
}
