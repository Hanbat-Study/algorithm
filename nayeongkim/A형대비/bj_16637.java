import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_16637 {
    static int n, res;
    static ArrayList<String> op = new ArrayList<>();
    static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num.add(Integer.parseInt(s[i]));
            } else {
                op.add(s[i]);
            }
        }
        res = Integer.MIN_VALUE;
        dfs(num.get(0), 0);
        System.out.println(res);
    }

    private static void dfs(int sum, int idx) {
        if (idx >= op.size()) {
            res = Math.max(res, sum);
            return;
        }
        dfs(calc(sum, num.get(idx + 1), op.get(idx)), idx + 1);
        if (idx + 1 < op.size()) {
            int next = calc(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1));
            dfs(calc(sum, next, op.get(idx)), idx + 2);
        }
    }

    private static int calc(int sum, int num, String s) {
        if (s.equals("+")) {
            return sum + num;
        } else if (s.equals("-")) {
            return sum - num;
        } else {
            return sum * num;
        }
    }
}
