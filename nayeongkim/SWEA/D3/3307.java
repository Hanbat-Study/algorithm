import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] list = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i <n; i++) {
				list[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && list[i] <list[j] + 1) list[i] = list[j] + 1;
				}
			}
			int max = 0;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, list[i]);
			}
			System.out.println("#"+ t+ " "+ max);
		}
		
	}
}
