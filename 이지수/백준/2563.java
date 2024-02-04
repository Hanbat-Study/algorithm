import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] paper = new boolean[100][100];
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int leftBtmX = Integer.parseInt(str[0]);
			int leftBtmY = Integer.parseInt(str[1]);
			
			for(int y = leftBtmY - 1; y < leftBtmY + 9; y++) {
				for(int x = leftBtmX - 1; x < leftBtmX + 9; x++) {
					paper[y][x] = true;
				}
			}
		}
		
		int m = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j])
					m++;
			}
		}
		
		System.out.println(m);
	}
}
