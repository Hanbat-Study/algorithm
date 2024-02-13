import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int down;
		int up;

		Node(int down, int up) {
			this.down = down;
			this.up = up;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.down != o.down ? this.down - o.down : o.up - this.up;
		}

		@Override
		public String toString() {
			return "Node [down=" + down + ", up=" + up + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Node[] list = new Node[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int down = Integer.parseInt(st.nextToken());
			int up = Integer.parseInt(st.nextToken());

			list[i] = new Node(down, up);
		}

		Arrays.sort(list);

		List<Node> temp = new ArrayList<>();

		temp.add(list[0]);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= temp.size(); j++) {
				if (j == temp.size()) {
					temp.add(list[i]);
					break;
				}

				if (temp.get(j).down <= list[i].down && temp.get(j).up >= list[i].down) {
					temp.get(j).down = list[i].down;
					if (temp.get(j).up > list[i].up) {
						temp.get(j).up = list[i].up;
					}
					break;
				}

			}
		}

		System.out.println(temp.size());

	}
}
