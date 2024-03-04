import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Character> list = new ArrayList<>();
	static char[] arr;
	static boolean[] visited;
	static int l;
	static int c;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		list.add('a');
		list.add('e');
		list.add('i');
		list.add('o');
		list.add('u');

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		arr = new char[c];
		visited = new boolean[c];

		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		dfs(0, 0, 0);

		System.out.println(sb);

	}

	static void dfs(int depth, int cnt, int pre) {

		if (depth == l) {
			if (cnt > 0 && l - cnt > 1) {
				for (int i = 0; i < c; i++) {
					if (visited[i]) {
						sb.append(arr[i]);
					}
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = pre; i < c; i++) {

			if (list.contains(arr[i]) && l - cnt > 2) {
				visited[i] = true;
				dfs(depth + 1, cnt + 1, i + 1);
				visited[i] = false;
			} else if(!list.contains(arr[i])) {
				visited[i] = true;
				dfs(depth + 1, cnt, i + 1);
				visited[i] = false;
			}
		}

	}
}
