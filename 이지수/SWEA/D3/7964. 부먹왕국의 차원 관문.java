import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//pm 4:41~
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] tmp = br.readLine().split(" ");
            int N = Integer.parseInt(tmp[0]);
            int D = Integer.parseInt(tmp[1]);
            
            String[] map = br.readLine().split(" ");
            int result = 0;
            int idx = Arrays.asList(map).indexOf("1");
            if(idx == -1) {
                System.out.println("#" + test_case + " " + N/D);
            	continue;
            }
            
            int left = D - 1;
            for(int i = idx; i >= 0; i--) {
                if(map[i].equals("0")) {
                	if(left == 0) {
                    	result++;
                        left = D - 1;
                    }
                    else
                    	left--;
                }
                else
                    left = D - 1;
            }
            for(int i = idx; i < N; i++) {
                if(map[i].equals("0")) {
                	if(left == 0) {
                    	result++;
                        left = D - 1;
                    }
                    else
                    	left--;
                }
                else
                    left = D - 1;
            }
            System.out.println("#" + test_case + " " + result);
		}
	}
}
