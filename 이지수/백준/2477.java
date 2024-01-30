import java.io.*;
import java.util.Arrays;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		boolean[] dir = new boolean[4];
		int[][] info = new int[6][2];
		int lidx1 = -1;
		int lidx2 = -1;
		
		for(int i = 0; i < 6; i++) {
			String[] str = br.readLine().split(" ");
			int d = Integer.parseInt(str[0]);
			info[i][0] = d;
			info[i][1] = Integer.parseInt(str[1]);
			if(dir[d - 1])
				dir[d - 1] = false;
			else
				dir[d - 1] = true;
		}

		for(int i = 0; i < 6; i++) {
			if(dir[info[i][0] - 1] && lidx1 == -1)
				lidx1 = i;
			else if(dir[info[i][0] - 1] && lidx2 == -1)
				lidx2 = i;
		}
		
		int sidx1 = 0;
		int sidx2 = 0;
		if(Math.abs(lidx1 - lidx2) > 1) {
			sidx1 = Math.min(lidx1, lidx2) + 2;
			sidx2 = Math.min(lidx1, lidx2) + 3;
		}
		else {
			if(Math.max(lidx1, lidx2) + 2 > 5) {
				sidx1 = Math.max(lidx1, lidx2) + 2 - 6;
				sidx2 = Math.max(lidx1, lidx2) + 3 - 6;
			}
			else if(Math.max(lidx1, lidx2) + 3 > 5) {
				sidx1 = Math.max(lidx1, lidx2) + 2;
				sidx2 = Math.max(lidx1, lidx2) + 3 - 6;
			}
			else {
				sidx1 = Math.max(lidx1, lidx2) + 2;
				sidx2 = Math.max(lidx1, lidx2) + 3;
			}
		}

		System.out.println(K * (info[lidx1][1] * info[lidx2][1] - info[sidx1][1] * info[sidx2][1]));
	}
}
