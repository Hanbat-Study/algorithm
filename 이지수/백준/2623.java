import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int[] in = new int[N + 1];
		ArrayList<Integer>[] input = new ArrayList[N + 1];
		
		for(int i = 0; i < M; i++) {
			tmp = br.readLine().split(" ");
			
			int start = Integer.parseInt(tmp[1]);
			
			for(int j = 2; j < tmp.length; j++) {
				if(input[start] == null)
					input[start] = new ArrayList<Integer>();

				int end = Integer.parseInt(tmp[j]);
				
				if(input[start].contains(end)) {
					start = end;
					continue;
				}
				
				input[start].add(end);
				in[end]++;
				
				start = end;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = 1; i <= N; i++) {
			if(in[i] == 0)
				q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();

			if(in[cur] == 0) {
				sb.append(cur).append("\n");
				cnt++;
			}
			
			if(input[cur] == null) continue;
			
			for(int j = 0; j < input[cur].size(); j++) {
				int e = input[cur].get(j);
				
				in[e]--;

				if(in[e] == 0)
					q.offer(e);
			}
		}

		if(cnt < N)
			System.out.println(0);
		else
			System.out.println(sb.toString().trim());
	}
}
