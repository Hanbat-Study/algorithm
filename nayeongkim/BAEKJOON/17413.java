import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (char ch : str.toCharArray()) {
            if(ch == '<') {
                flag = true;
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append("<");
            } else if (ch == '>') {
                flag = false;
                sb.append(">");
            } else if (ch == ' ') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            } else {
                if (!flag) {
                    stack.push(ch);
                }
                else {
                    sb.append(ch);
                }
            }
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}