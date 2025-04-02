import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int num, result;
    static String s;
    static boolean flag;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        num = 1;
        result = 0;

        stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                num *= 2;

                stack.push(c);
            } else if (c == '[') {
                num *= 3;

                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || !stack.peek().equals('[')) {
                    result = 0;

                    break;
                } else if (s.charAt(i - 1) == '[') result += num;

                stack.pop();

                num /= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || !stack.peek().equals('(')) {
                    result = 0;

                    break;
                } else if (s.charAt(i - 1) == '(') result += num;

                stack.pop();

                num /= 2;
            }
        }



        if (stack.empty()) System.out.println(result);
        else System.out.println(0);
    }
}
