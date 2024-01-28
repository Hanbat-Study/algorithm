import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int N = s.length;
        int R = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                R = i;
            }
        }

        int C = N / R;
        String[][] arr = new String[R][C];

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                arr[j][i] = s[cnt++];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);
    }
}
