import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int arr[][] = new int[100][100];

		for (int k = 1; k < n + 1; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int i = r; i < r + a; i++) {
				for (int j = c; j < c + b; j++) {
					if (0 <= i && i < 100 && 0 <= j && j < 100) {
						arr[i][j] = k;
					}
				}
			}
		}
		int result = 0;
		int[] check = new int[n + 1];

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				check[arr[i][j]] += 1;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			System.out.println(check[i]);
		}
	}

}
