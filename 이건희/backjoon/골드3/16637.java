import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<Character> ope;
    static ArrayList<Integer> nums;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        ope = new ArrayList<>();
        nums = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums.add(s.charAt(i) - '0');
            } else {
                ope.add(s.charAt(i));
            }
        }
        
        dfs(nums.get(0), 0);

        System.out.println(maxResult);
    }

    private static void dfs(int result, int idx) {
        if (idx == ope.size()) {
            maxResult = Math.max(maxResult, result);
            return;
        }
        
        dfs(calc(result, ope.get(idx), nums.get(idx + 1)), idx + 1);
        
        if (idx + 1 < ope.size()) {
            int next = calc(nums.get(idx + 1), ope.get(idx + 1), nums.get(idx + 2));
            dfs(calc(result, ope.get(idx), next), idx + 2);
        }
    }

    private static int calc(int num1, char op, int num2) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        }
        return 0;
    }
}
