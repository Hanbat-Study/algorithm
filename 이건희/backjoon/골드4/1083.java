import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (S <= 0) break;

            int maxNum = i;

            for (int j = i + 1; j < N && j <= i + S; j++) {
                if (A[maxNum] < A[j]) maxNum = j;
            }

            for (int j = maxNum; j > i && S > 0; j--) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                S--;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(A[i]);
            if (i < N - 1) sb.append(" ");
        }

        System.out.println(sb);
    }
}
