import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

	static int[][][] tomatos;
	static int H, N, M;
	static ArrayList<int[]> matureTomatos = new ArrayList<int[]>();
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		M = Integer.parseInt(tmp[0]);
		N = Integer.parseInt(tmp[1]);
		H = Integer.parseInt(tmp[2]);
		
		int tomatoCnt = 0;
		tomatos = new int[H][N][M];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				tmp = br.readLine().split(" ");
				for(int k = 0; k < M; k++) {
					tomatos[i][j][k] = Integer.parseInt(tmp[k]);
					if(tomatos[i][j][k] != -1)
						tomatoCnt++;
					if(tomatos[i][j][k] == 1)
						matureTomatos.add(new int[] {i, j, k});
				}
			}
		}
		
		if(matureTomatos.size() == tomatoCnt) {
			System.out.println(0);
			return;
		}
		
		int result[] = BFS();
		if(result[0] + matureTomatos.size() < tomatoCnt)
			System.out.println(-1);
		else
			System.out.println(result[1]);
	}
	
	private static int[] BFS() {
		int tomatoCnt = 0;
		int recurCnt = 0;
		Queue<int[]> hasToVisit = new ArrayDeque<int[]>();
		
		for(int i = 0; i < matureTomatos.size(); i++)
			hasToVisit.offer(matureTomatos.get(i));
		
		int[] dh = {-1, 1, 0, 0, 0, 0};
		int[] dx = {0, 0, 1, -1, 0, 0};
		int[] dy = {0, 0, 0, 0, 1, -1};
		
		int[] cur;
		while(!hasToVisit.isEmpty()) {

			int size = hasToVisit.size();
			for(int n = 0; n < size; n++) {
				cur = hasToVisit.poll();

				for(int i = 0; i < 6; i++) {
					int idxH = cur[0] + dh[i];
					int idxR = cur[1] + dx[i];
					int idxC = cur[2] + dy[i];
					
					if(idxH < 0 || idxH >= H || idxR < 0 || idxR >= N || idxC < 0 || idxC >= M || tomatos[idxH][idxR][idxC] != 0)
						continue;
					
					hasToVisit.offer(new int[] {idxH, idxR, idxC});
					tomatos[idxH][idxR][idxC] = 1;
					tomatoCnt++;
				}
			}			
		
			recurCnt++;
		}
		
		return new int[] {tomatoCnt, recurCnt - 1};
	}
}
