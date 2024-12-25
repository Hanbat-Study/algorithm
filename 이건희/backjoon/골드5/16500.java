import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static int N;
    static String[] words;
    static boolean[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        memo = new boolean[S.length() + 1];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (cal(0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean cal(int n) {
        if (n == S.length()) {
            return true;
        }

        if (memo[n]) {
            return false;
        }

        memo[n] = true;

        for (int i = 0; i < N; i++) {
            String word = words[i];

            if (n + word.length() <= S.length() && S.substring(n, n + word.length()).equals(word)) {
                if (cal(n + word.length())) {
                    return true;
                }
            }
        }

        return false;
    }
}
