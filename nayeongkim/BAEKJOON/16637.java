import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

class Main_16637 {
    static int res, n;
    static ArrayList<Character> ops;
    static ArrayList<Integer> nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        ops = new ArrayList<>();
        nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
            }
            else nums.add(c - '0');
        }
        res = Integer.MIN_VALUE;
        dfs(nums.get(0), 0);
        System.out.println(res);
    }

    private static void dfs(int sum, int idx) {
        if (idx >= ops.size()) {
            res = Math.max(res, sum);
            return;
        }
        dfs(cal(sum, nums.get(idx + 1), ops.get(idx)), idx + 1);
        if (idx + 1 < ops.size()) {
            int bracketSum = cal(nums.get(idx + 1), nums.get(idx + 2), ops.get(idx + 1));
            dfs(cal(sum, bracketSum, ops.get(idx)), idx + 2);
        }
    }

    private static int cal(int sum, int num, int op) {
        if (op == '+') return sum + num;
        else if (op =='*') return sum * num;
        else return sum - num;
    }
}