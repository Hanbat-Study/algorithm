import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (now <= stack.peek()[1]) {
                    result.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.append(0).append(" ");
            }
            stack.add(new int[] {i, now});
        }
        System.out.println(result);
    }
}
