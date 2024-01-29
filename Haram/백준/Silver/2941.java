import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for(int i = 0; i < croatia.length; i++) {
			if(str.contains(croatia[i])) 
				str = str.replace(croatia[i], "*");
		}
		
		System.out.println(str.length());
	}
}
