import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = 0;
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                result++;
            }

            if (!stack.isEmpty() && stack.peek() == y) continue;

            if (0 < y) stack.add(y);
        }

        result += stack.size();

        System.out.println(result);
    }
}
