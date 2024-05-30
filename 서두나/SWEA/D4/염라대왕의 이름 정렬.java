import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = Integer.parseInt(br.readLine());
			String[] words = new String[n];

			for (int i = 0; i < n; i++) {
				words[i] = br.readLine();
			}
			mergeSort(words);
			System.out.println("#"+test_case);
			String prev="";
			for(String word: words) {
				if(!word.equals(prev)) {
					System.out.println(word);
				}
				prev=word;
			}
		}
	}

	private static void mergeSort(String[] words) {

		if (words.length == 1) {
			return;
		}
		int center = words.length / 2;
		String[] head = arrCopy(words, 0, center);
		String[] tail = arrCopy(words, center, words.length);
		mergeSort(head);
		mergeSort(tail);

		int headPtr = 0;
		int tailPtr = 0;
		int index = 0;
		while (index < words.length) {
			if (headPtr == head.length) {
				words[index] = tail[tailPtr];
				tailPtr++;
			} else if (tailPtr == tail.length) {
				words[index] = head[headPtr];
				headPtr++;
			} else {
				if (compare(head[headPtr], tail[tailPtr])) {
					words[index] = tail[tailPtr];
					tailPtr++;
				} else {
					words[index] = head[headPtr];
					headPtr++;
				}
			}
			index++;
		}
		return;
	}

	private static boolean compare(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return str1.length() > str2.length();
		}
		for (int i = 0; i < Math.max(str1.length(), str2.length()); i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if (c1 != c2) {
				return c1 > c2;
			}
		}
		return false;
	}

	private static String[] arrCopy(String[] words, int start, int end) {
		String[] result = new String[end - start];
		for (int i = start; i < end; i++) {
			result[i - start] = words[i];
		}
		return result;
	}
}
