package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static int getShape(char c) {
		if (c == 'S') {
			return 0;
		}
		if (c == 'D') {
			return 1;
		}
		if (c == 'H') {
			return 2;
		}
		return 3;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/algorithm/solve_240121/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String card = br.readLine();
			boolean cards[][] = new boolean[4][13];
			for (int i = 0; i < 4; i++) {
				cards[i] = new boolean[13];
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < card.length(); i += 3) {
				int sh = getShape(card.charAt(i));
				int num = (card.charAt(i + 1) - '0') * 10 + (card.charAt(i + 2) - '0');
				if (cards[sh][num-1]) {
					sb.append("ERROR");
					break;
				}
				cards[sh][num-1] = true;
			}
			if (!sb.toString().equals("ERROR")) {
				for (int i = 0; i < 4; i++) {
					int temp = 13;
					for (int j = 0; j < 13; j++) {
						if (cards[i][j]) {
							temp--;
						}
					}
					sb.append(temp);
					sb.append(" ");
				}
			}
			System.out.println("#"+test_case+" "+sb.toString());
		}
	}
}
