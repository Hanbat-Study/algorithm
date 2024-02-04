import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            int result = 0;
            int cnt = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("O")) {
                    cnt++;
                    result += cnt;
                } else cnt = 0;
            }
            System.out.println(result);
        }
    }
}
