import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static long result;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.empty()) {
                if (stack.peek() <= h) stack.pop();
                else break;
            }

            result += stack.size();

            stack.push(h);
        }

        System.out.println(result);
    }
}
