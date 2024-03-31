import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[] parents;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parents = new int[N + 1];
 
            makeSet();
 
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
 
            Set<Integer> parentSet = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                parentSet.add(find(i));
            }
            System.out.printf("#%d %d\n", test_case, parentSet.size());
        }
    }
 
    private static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot != bRoot) {
            if (aRoot < bRoot) {
                parents[bRoot] = aRoot;
            } else {
                parents[aRoot] = bRoot;
            }
        }
    }
 
    private static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }
}
