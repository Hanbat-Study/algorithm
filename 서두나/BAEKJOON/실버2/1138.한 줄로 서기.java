import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] ans;
	static boolean[] visited = new boolean[11];
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		ans = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		rec(0);
		System.out.println(sb.toString());
	}

	static void rec(int d) {

		if (d == n) {
			for(int i=0;i<n;i++) {
				sb.append(ans[i]+" ");
			}
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && check(d, i)) {
				visited[i] = true;
				ans[d]=i;
				rec(d + 1);
				visited[i] = false;
			}
		}
	}

	static boolean check(int d, int k) {
		int cnt = 0;
		for (int i = 0; i < d; i++) {
			if (ans[i] > k) {
				cnt++;
			}
		}
		return cnt == arr[k - 1];
	}

}
