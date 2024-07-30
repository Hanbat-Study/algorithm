import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	static class Node {
		int skill, index;

		Node(int skill, int index) {
			this.skill = skill;
			this.index = index;
		}
	}

	static int[] tree;
	static List<Node> skills;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		skills = new ArrayList<>();
		tree = new int[n * 4];

		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			skills.add(new Node(k, i));
		}

		// 1,000,000,000 범위가 크므로 n의 최대 개수 50만이고 겹치는 능력도 없으므로 1~n까지 다시 매칭
		Collections.sort(skills, (o1, o2) -> o1.skill - o2.skill);

		for (int i = 0; i < n; i++) {
			skills.get(i).skill = i + 1;
		}

		Collections.sort(skills, (o1, o2) -> o1.index - o2.index);

		for (int i = 0; i < n; i++) {
			int cnt = find(1, 0, n - 1, 0, skills.get(i).skill); // 현재 능력보다 작은 능력 사람 수
			update(1, 0, n - 1, skills.get(i).skill);
			sb.append((i + 1 - cnt) + "\n");
		}

		System.out.println(sb.toString());
	}

	static private int find(int node, int left, int right, int leftIndex, int rightIndex) {

		if (left > rightIndex || right < leftIndex) {
			return 0;
		}
		if (leftIndex <= left && right <= rightIndex) {
			return tree[node];
		}

		int mid = (left + right) / 2;

		int leftNode = find(node * 2, left, mid, leftIndex, rightIndex);
		int rightNode = find(node * 2 + 1, mid + 1, right, leftIndex, rightIndex);

		return leftNode + rightNode;
	}

	static private void update(int node, int left, int right, int index) {

		if (index < left || index > right) {
			return;
		}
		if (left == right) {
			tree[node]++;
			return;
		}

		int mid = (left + right) / 2;

		update(node * 2, left, mid, index);
		update(node * 2 + 1, mid + 1, right, index);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
