import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Point[] busLine = new Point[N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				busLine[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int P = Integer.parseInt(br.readLine());
			int[] result = new int[P];
			
			for(int i = 0; i < P; i++) {
				int c = Integer.parseInt(br.readLine());
				for(int j = 0; j < N; j++) {
					if(busLine[j].x <= c && c <= busLine[j].y) 
						result[i]++;
				}
			}
			
			System.out.printf("#%d", t+1);	
			for(int ele : result) 
				System.out.print(" " + ele);
			
			System.out.println();
 		}
	}
}