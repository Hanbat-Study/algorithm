import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] inputs = new int[9];
		
		for(int i = 0; i < 9; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(inputs);
		
		int f1 = 0;
		int f2 = 1;
		
		while(true) {
			if(sum(inputs, f1, f2) == 100)
				break;
			
			f2++;
			if(f2 > 8) {
				f1++;
				f2 = f1+1;
			}
		}
		

		for(int i = 0; i < 9; i++) {
			if(i == f1 || i == f2)
				continue;
			System.out.println(inputs[i]);
		}
 	}

	private static int sum(int[] arr, int f1, int f2) {
		int sum = 0;
		
		for(int i = 0; i < 9; i++) {
			if(i == f1 || i == f2)
				continue;
			sum += arr[i];
		}
			
		return sum;
	}
}
