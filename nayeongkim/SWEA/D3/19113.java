import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            int[] money = new int[2 *n];
            int[] discount = new int[n];
            boolean visited[] = new boolean[2 * n];
            int idx = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2* n; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }
            for (int i =0; i < 2*n - 1; i++) {
                for (int j = i + 1;j < 2 * n; j++) {
                    if (money[i] == money[j]* 0.75 && !visited[j] &&!visited[i]) {
                        discount[idx++] = money[i];
                        visited[j] = true;
                        visited[i] = true;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                sb.append(discount[i]).append(" ");
            }
            System.out.println("#" + t+ " "+ sb);
        }
    }
}
