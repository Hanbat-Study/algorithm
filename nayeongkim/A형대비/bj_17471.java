import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class Main {
	static int n, res;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(new ArrayList<>());
	static int[] people;
	static int[] parent;
	static boolean[] isSelected;
	static ArrayList<Integer> groupA;
	static ArrayList<Integer> groupB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		parent = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>());
		}
		graph.add(new ArrayList<>());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				int connected = Integer.parseInt(st.nextToken());
				graph.get(i).add(connected);
			}
		}
		res = Integer.MAX_VALUE;
		isSelected = new boolean[n + 1];
		comb(1);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	private static void comb(int idx) {
		if (idx > n) {
			if (isValid()) {
				cal();
			}
			return;
		}
		isSelected[idx] = true;
		comb(idx + 1);
		isSelected[idx] = false;
		comb(idx + 1);
		
	}
	private static void cal() {
		int sumA = 0;
		int sumB = 0;
		for (int i = 1; i <=n; i++) {
			if (isSelected[i]) sumA += people[i];
			else sumB += people[i];
		}
		res = Math.min(res, Math.abs(sumA - sumB));
	}
	private static boolean isValid() {
		int groupA = -1;
		int groupB = -1;
		make();
		
		for (int i = 1; i <= n; i++) {
			for (int e : graph.get(i)) {
				if (isSelected[i] == isSelected[e]) {
					union(i, e);
				}

			}		
		}
		for (int i = 1; i<= n; i++) {
			if (isSelected[i]) {
				if (groupA == -1) groupA = find(i);
				else if (groupA != find(i)) return false;
			}
			else {
				if (groupB == -1) groupB = find(i);
				else if (groupB != find(i)) return false;
			}
		}
		return groupA != -1 && groupB != -1;
		
	}
	private static void union(int i, int e) {
		int x = find(i);
		int y = find(e);
		if (x != y) parent[y] = x;
		
	}
	private static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
		
	}
	private static void make() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	

}
