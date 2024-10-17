import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            result.append(s.charAt(i));

            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') result.append('1');
            if (s.charAt(i) == ')' && s.charAt(i + 1) == '(') result.append('+');
        }

        result.append(")");

        System.out.println(result);
    }
}
