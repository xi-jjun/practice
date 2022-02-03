package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = "";
		while ((input = br.readLine()) != null) {
			bw.write(input + "\n");
//			System.out.println(input);
//			bst.insert(Integer.parseInt(input));
//			bw.flush();
		}

//		bst.postOrderTraversal(root);

		bw.flush();
		bw.close();
	}
}
