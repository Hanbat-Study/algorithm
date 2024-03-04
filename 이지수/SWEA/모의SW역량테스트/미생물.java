import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static ArrayList<int[]> m;
	static boolean[][] area;
	static int N, K;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int M;
		
		for(int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			K = Integer.parseInt(tmp[2]);
			area = new boolean[N][N];
			m = new ArrayList<int[]>();
			
			for(int k = 0; k < K; k++) {
				tmp = br.readLine().split(" ");
				int r = Integer.parseInt(tmp[0]);
				int c = Integer.parseInt(tmp[1]);
				
				m.add(new int[] {r, c, Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3])});
				area[r][c] = true;
			}
			
			for(int i = 0; i < M; i++)
				move();
			
			int sum = 0;
			for(int i = 0; i < m.size(); i++)
				sum += m.get(i)[2];
			
			System.out.println("#" + t + " " + sum);
		}
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	
	private static void move() {
		Map<int[], ArrayList<Integer>> selected = new HashMap<>();
		ArrayList<int[]> points = new ArrayList<int[]>(); 
		
		for(int i = 0; i < K; i++) {
			if(m.get(i)[2] == 0) continue;
			
			int dir = m.get(i)[3];
			
			if(m.get(i)[0] == 0 || m.get(i)[1] == 0 || m.get(i)[0] == N - 1 || m.get(i)[1] == N - 1) {
				if(dir == 1 || dir == 3)
					m.get(i)[3]++;
				else
					m.get(i)[3]--;
				
				dir = m.get(i)[3];
			}
			
			int r = m.get(i)[0] + dx[dir - 1];
			int c = m.get(i)[1] + dy[dir - 1];
			
			if(r == 0 || c == 0 || r == N - 1 || c == N - 1)
				m.get(i)[2] = m.get(i)[2] / 2;
			
			area[m.get(i)[0]][m.get(i)[1]] = false;
			area[r][c] = true;

			int idx = 0;
			for(; idx < points.size(); idx++) {
				if(points.get(idx)[0] == r && points.get(idx)[1] == c)
					break;
			}
			
			if(idx == points.size())
				points.add(new int[] {r, c});
			
			if(selected.get(points.get(idx)) == null)
				selected.put(points.get(idx), new ArrayList<Integer>());
			selected.get(points.get(idx)).add(i);
			
			m.get(i)[0] = r;
			m.get(i)[1] = c;
		}
		
		for(int i = 0; i < points.size(); i++) {
			if(selected.get(points.get(i)).size() == 1) continue;

			int[] cur = points.get(i);
			int max = selected.get(cur).get(0);
			int sum = m.get(max)[2];
			for(int j = 1; j < selected.get(cur).size(); j++) {
				System.out.println("sum : " + sum);
				int mIdx = selected.get(cur).get(j);
				sum += m.get(mIdx)[2];
				
				if(m.get(max)[2] < m.get(mIdx)[2]) {
					m.get(max)[2] = 0;
					max = mIdx;
				}
				else
					m.get(mIdx)[2] = 0;
				
			}
			
			m.get(max)[2] = sum;
		}
		
		System.out.println("start2");
		for(int i = 0; i < K; i++)
			System.out.println(Arrays.toString(m.get(i)));
	}
}
