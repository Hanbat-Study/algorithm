import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1182 {
    static int n, s, count;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        perm(0, 0);
        System.out.println(s != 0 ? count : count -1);
    }

    private static void perm(int sum, int cnt) {
        if (cnt == n) {
            if (sum == s) {
                count++;
            }
            return;
        }
        perm(sum + nums[cnt], cnt + 1);
        perm(sum, cnt + 1);
    }
}