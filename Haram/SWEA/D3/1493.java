import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			Point a = new Point();
			Point b = new Point();
			
			int[][] numBoard = new int[300][300];
			
			int num = 1;
			for(int i = 2; i < 300; i++) {
				for(int j = 1; j < i; j++) {
					numBoard[j][i-j] = num;
					if(num == p) {
						a.x = j;
						a.y = i-j;
					} 
					if(num == q) {
						b.x = j;
						b.y = i-j;
					}
					num++;
				}				
			}
			
			int x = a.x + b.x;
			int y = a.y + b.y;
			
			System.out.printf("#%d %d\n", t+1, numBoard[x][y]);
		}
	}		
}