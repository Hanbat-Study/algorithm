import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long result;
    static char[] password;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        password = br.readLine().toCharArray();
        result = 0;

        for (int i = 0; i < password.length; i++) {
            if (i == N - 1) {
                result += password[i] - 'a' + 1;
                break;
            }

            long cnt = 26;

            for (int j = i + 2; j < N; j++) {
                cnt  = cnt * 26 + 26;
            }

            result += (password[i] - 'a') * cnt + (password[i] - 'a' + 1);
        }

        System.out.println(result);
    }
}
