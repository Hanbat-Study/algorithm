import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static private String DIFF = "DIFF";
	static private String SAME = "SAME";
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			boolean flag = true;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String firstStr = st.nextToken();
			String secondStr = st.nextToken();
			
			if(firstStr.length() != secondStr.length()) {
				System.out.println("#" + (t+1) + " " + DIFF);
				continue;
			}
				
			for(int i = 0; i < firstStr.length(); i++) {
				if(whatType(firstStr.charAt(i)) != whatType(secondStr.charAt(i))) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				System.out.println("#" + (t+1) + " " + SAME);
			else
				System.out.println("#" + (t+1) + " " + DIFF);
		}
	}

	private static int whatType(char alpha) {
		if('B' == alpha)
			return 2;
		else if("ADOPQR".indexOf(alpha) != -1)
			return 1;
		else
			return 0;
	}
}