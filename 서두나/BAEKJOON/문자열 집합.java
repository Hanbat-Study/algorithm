import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TreeSet<String> ts = new TreeSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			ts.add(br.readLine());
		}

		int cnt = 0;

		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			String first = ts.ceiling(temp);
			
			if (first != null && first.equals(temp)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
