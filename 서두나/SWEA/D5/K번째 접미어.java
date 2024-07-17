import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;

public class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int k = Integer.parseInt(br.readLine());
			String word = br.readLine();

			TreeMap<String, Boolean> treeMap = new TreeMap<>();

			for (int i = 0; i < word.length(); i++) {
				treeMap.put(word.substring(i, word.length()), null);
			}

			NavigableSet<String> keySet = treeMap.navigableKeySet();
			List<String> keyList = new ArrayList<>(keySet);

			System.out.println("#" + test_case + " " + keyList.get(k - 1));
		}
	}
}
