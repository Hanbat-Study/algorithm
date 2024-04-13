import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		TreeMap<String,Boolean> map = new TreeMap<>();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int cnt=0;
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				map.put(st.nextToken(), true);
			}
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {
				if(map.getOrDefault(st.nextToken(),false)) {
					cnt++;
				}
			}

			System.out.println("#"+test_case+" "+cnt);
            map.clear();
		}
	}
}
