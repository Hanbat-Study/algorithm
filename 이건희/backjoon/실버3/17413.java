import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("");
        Stack<String> words = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean check = false;

        for (String s : strings) {
            if (s.equals("<")) {
                if (sb.length() > 0) {
                    words.push(sb.toString());
                    sb = new StringBuilder();

                }
                check = true;
                sb.append(s);
            } else if (!check && s.equals(" ")) {
                words.push(sb.toString());
                words.push(" ");
                sb = new StringBuilder();
            } else if (s.equals(">")) {
                sb.append(s);
                words.push(sb.toString());
                sb = new StringBuilder();
                check = false;
            } else sb.append(s);
        }
        if (sb.length() > 0) words.push(sb.toString());

        for (int i = 0; i < words.size(); i++) {
            String now = words.get(i);
            if (now.startsWith("<")) {
                result.append(now);
            } else if (now.equals(" ")) {
                result.append(" ");
            } else {
                StringBuffer s = new StringBuffer(now);
                now = s.reverse().toString();
                result.append(now);
            }
        }
        System.out.println(result);
    }
}
