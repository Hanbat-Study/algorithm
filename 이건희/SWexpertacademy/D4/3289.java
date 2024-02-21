import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int n;
    static int[] parents;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
             
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parents = new int[n + 1];
             
            makeSet();
             
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                if (Integer.parseInt(st.nextToken()) == 0) {
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else {
                    if (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))) {
                        sb.append(1);
                    } else sb.append(0);
                }
            }
             
            System.out.printf("#%d %s\n", test_case, sb);
        }
    }
     
    private static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] =  find(parents[a]);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
         
        if (aRoot != bRoot) {
            parents[aRoot] = bRoot;
        } else parents[bRoot] = aRoot;
    }
 
    private static void makeSet() {
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    } 
}
