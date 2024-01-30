import java.io.BufferedReader;
import java.io.InputStreamReader;
//a.m. 10 : 32 ~
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[] A = br.readLine().split(" ");
			String[] B = br.readLine().split(" ");
			
			int[] AHas = new int[4];
			int[] BHas = new int[4];
			
			for(int a = 1; a <= Integer.parseInt(A[0]); a++)
				AHas[Integer.parseInt(A[a]) - 1]++;
			
			for(int b = 1; b <= Integer.parseInt(B[0]); b++)
				BHas[Integer.parseInt(B[b]) - 1]++;
			
			if(AHas[3] > BHas[3] || (AHas[3] == BHas[3] && AHas[2] > BHas[2]) || (AHas[3] == BHas[3] && AHas[2] == BHas[2] && AHas[1] > BHas[1]) || (AHas[3] == BHas[3] && AHas[2] == BHas[2] && AHas[1] == BHas[1] && AHas[0] > BHas[0]))
				System.out.println("A");
			else if(AHas[3] == BHas[3] && AHas[2] == BHas[2] && AHas[1] == BHas[1] && AHas[0] == BHas[0])
				System.out.println("D");
			else
				System.out.println("B");
		}
	}
}
