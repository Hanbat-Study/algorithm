import java.io.*;
import java.util.*;

class Node1 {
	int d;
	int m;

	Node1(int d, int m) {
		this.d = d;
		this.m = m;
	}
}
public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int oneM2 = Integer.parseInt(br.readLine());
		int maxL = 0;
		int maxW = 0;
		List<Node1> list = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int dir = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			list.add(new Node1(dir, m));
		}

		int minSquar=0;
		for (int i = 0; i < 6; i++) {
			if (list.get(i).d == list.get((i + 2) % 6).d && list.get((i + 1) % 6).d == list.get((i + 3) % 6).d) {
				minSquar = list.get((i + 1) % 6).m * list.get((i + 2) % 6).m;
			}
			else if (list.get(i).d==1 || list.get(i).d==2) {
				maxL = Math.max(maxL, list.get(i).m);				
			}else {
				maxW = Math.max(maxW, list.get(i).m);
				
			}
		}
		System.out.println((maxW * maxL - minSquar) * oneM2);
	}
}
