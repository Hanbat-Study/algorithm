import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        result = 0;

        cal(T);

        System.out.println(result);
    }

    public static void cal(String s) {
        if (s.length() == S.length()) {
            if (s.equals(S)) {
                result = 1;
            }

            return;
        }

        if (s.endsWith("A")) cal(s.substring(0, s.length() - 1));
        
        if (s.startsWith("B")) cal(new StringBuilder(s.substring(1)).reverse().toString());
    }
}
