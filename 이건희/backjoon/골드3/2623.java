import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int in[] = new int[N + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int now = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				list.get(now).add(num);
				in[num]++;
				
				now = num;
			}
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int d = queue.poll();
			result.add(d);
			
			for (int n : list.get(d)) {
				in[n]--;
				
				if (in[n] == 0) {
					queue.offer(n);
				}
			}
			
		}
		
		if (result.size() != N) {
			System.out.println(0);
			return;
		}
		
		for (int n : result) {
			sb.append(n).append("\n");
		}
		
		System.out.println(sb);
	}
}
