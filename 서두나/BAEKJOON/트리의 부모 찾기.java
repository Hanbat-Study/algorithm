import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] parents;
	static boolean[] visited;

	static void recursive(int cur) {

		for (int next : graph.get(cur)) {
			if (visited[next]) {
				continue;
			}
			visited[next] = true;
			parents[next] = cur;
			recursive(next);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parents = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		visited[1] = true;
		recursive(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < n + 1; i++) {
			sb.append(parents[i]).append("\n");
		}

		System.out.println(sb);
	}
}
