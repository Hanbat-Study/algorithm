import java.io.*;
import java.util.Arrays;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarfs = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sum += dwarfs[i];
		}
		
		boolean flag = false;
		for(int i = 0; i < 8; i++) {
			for(int j = 1; j < 9; j++) {
				if((sum - dwarfs[i] - dwarfs[j]) == 100) {
					dwarfs[i] = 0;
					dwarfs[j] = 0;
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}
		
		Arrays.sort(dwarfs);
		for(int i = 2; i < 9; i++) {
			System.out.println(dwarfs[i]);
		}
	}
}
