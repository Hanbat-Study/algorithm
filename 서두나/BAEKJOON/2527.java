package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

	static int a, b, c, d;
	static int e, f, g, h;

	static char getWord() {

		// 범위 내에 있다.
		if (((a < e && e < c) && (b < f && f < d)) || ((a < g && g < c) && (b < h && h < d))) {
			return 'a';
		}
		if (((e < a && a < g) && (f < b && b < h)) || ((e < c && c < g) && (f < d && d < h))) {
			return 'a';
		}
		if (((a < e && e < c) && ((f < b && b < h) || (f < d && d < h))
				|| ((a < g && g < c) && ((f < b && b < h) || (f < d && d < h))))) {
			return 'a';
		}
		if (((e < a && a < g) && ((f < b && b < h) || (f < d && d < h)))
				|| ((e < c && c < g) && ((f < b && b < h) || (f < d && d < h)))) {
			return 'a';
		}

		// 선분, 점하나가 가로 세로 범위에 포함되고, 높이나 위치가 같다.
		if ((f == d || f == b || h == d || h == b) && ((a <= e && e <= c) || (a <= g && g <= c))) {
			return 'b';
		}
		if ((a == e || a == g || c == e || c == g) && ((b <= f && f <= d) || (b <= h && h <= d))) {
			return 'b';
		}

		// 점
		if ((a == g && b == h) || (c == e && d == f) || (c == e && b == h) || (a == g && d == f)) {
			return 'c';
		}

		return 'd';
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			e = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			System.out.println(getWord());
		}
	}
}
