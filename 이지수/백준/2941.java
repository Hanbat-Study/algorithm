import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] alphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String comb = "c=c-dz=d-ljnjs=z=";
		
		int result = 0;
		String str = br.readLine();
		int idx = 0;
		while(idx < str.length()) {
			boolean flag = false;
			for(int i = 0; i < alphabets.length; i++) {
				if(idx == str.length() - 1)
					break;
				if(idx < str.length() - 2 && i == 2 && alphabets[i].equals(str.substring(idx, idx + 3))) {
					result++;
					idx += 3;
					flag = true;
					break;
				}
				else if(i != 2 && alphabets[i].equals(str.substring(idx, idx + 2))) {
					result++;
					idx += 2;
					flag = true;
					break;
				}
			}
			if(!flag) {
				result++;
				idx++;
			}
		}
		
		System.out.println(result);
	}
}
