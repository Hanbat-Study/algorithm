import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;

public class Solution {
	static TreeMap<String, Boolean> map;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int k = Integer.parseInt(br.readLine());
			String temp = br.readLine();

			map = new TreeMap<>();

			for (int i = 0; i < temp.length(); i++) {
				for (int j = i; j <= temp.length(); j++) {
					map.put(temp.substring(i, j), null);
				}
			}

			NavigableSet<String> keySet = map.navigableKeySet();
			List<String> keyList = new ArrayList<>(keySet);

			System.out.println("#" + test_case + " " + keyList.get(k));
		}
	}

}
