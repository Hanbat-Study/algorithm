import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	static int[] moveA, moveB, a, b;
	static int[][] bc;
	static int res, M, A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			bc = new int[A][4];
			a = new int[2];
			b = new int[2];
			a[0] = a[1] = 1;
			b[0] = b[1] = 10;
			moveA = new int [M + 1];
			moveB = new int [M + 1];
			st = new StringTokenizer(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 1; i < M + 1; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
				moveB[i] = Integer.parseInt(st1.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i][0] = Integer.parseInt(st.nextToken()); // x
				bc[i][1] = Integer.parseInt(st.nextToken()); // y
				bc[i][2] = Integer.parseInt(st.nextToken()); // c
				bc[i][3] = Integer.parseInt(st.nextToken()); //p
			}
			
			System.out.println("#" + tc + " "+move());
		}
	}
	private static int move() {
		int total = 0;
		for (int d= 0; d <M + 1; d++) {
			a[0] += dc[moveA[d]];
			a[1] += dr[moveA[d]];
			b[0] += dc[moveB[d]];
			b[1] += dr[moveB[d]];
			
			total += getCharge(); 
		}
		return total;
	}
	private static int getCharge() {
		int maxSum = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = 0;
				int amountA = getDistance(i, a[0],a[1]);
				int amountB = getDistance(j, b[0], b[1]);
				
				if (i != j)	sum = amountA +amountB;
				else {
					sum = Math.max(amountA, amountB);
				}
				
				if (maxSum < sum) maxSum = sum;
			}
			
		}
		
		return maxSum;
	}
	private static int getDistance(int i, int x, int y) {
		
		return Math.abs(x - bc[i][0]) + Math.abs(y - bc[i][1]) <= bc[i][2]? bc[i][3] : 0 ;
	}
}


