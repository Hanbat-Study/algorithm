import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[101][101];
		for(int i = 0; i < T; i++) {
			String[] str = br.readLine().split(" ");
			int leftBtmX = Integer.parseInt(str[0]);
			int leftBtmY = Integer.parseInt(str[1]);

			for(int y = leftBtmY - 1; y <= leftBtmY + 10; y++) {
				if(y == leftBtmY - 1 || y == leftBtmY + 10) {
					for(int x = leftBtmX; x <= leftBtmX + 10; x++) {
						if(paper[y][x] != -1)
							paper[y][x] = 1;
					}
				}
				else {
					for(int x = leftBtmX - 1; x <= leftBtmX + 10; x++) {
						if(x == leftBtmX - 1 || x == leftBtmX + 10) {
							if(paper[y][x] != -1)
								paper[y][x] = 1;
						}
						else {
							paper[y][x] = -1;
						}
					}
				}
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int sum = 0;
		
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				if(paper[i][j] == -1) {
					for(int k = 0; k < 4; k++) {
						if(i + dx[k] >= 101 || i + dx[k] < 0 || j + dy[k] >= 101 || j + dy[k] < 0)
							continue;
						if(paper[i + dx[k]][j + dy[k]] == 1)
							sum++;
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}
