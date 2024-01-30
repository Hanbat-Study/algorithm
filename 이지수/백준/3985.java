import java.io.BufferedReader;
import java.io.InputStreamReader;
//
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] maxWants = {0, 0};
		int[] maxGets = {0, 0};
		int[] cakes = new int[L];
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			
			int wants = end - start + 1;
			if(wants > maxWants[1]) {
				maxWants[0] = i;
				maxWants[1] = wants;
			}
			
			int gets = 0;
			for(int x = start - 1; x <= end - 1; x++) {
				if(cakes[x] == 0) {
					cakes[x] = i + 1;
					gets++;
				}
			}
			if(gets > maxGets[1]) {
				maxGets[0] = i;
				maxGets[1] = gets;
			}
		}
		
		System.out.println(maxWants[0] + 1);
		System.out.println(maxGets[0] + 1);
	}
}
