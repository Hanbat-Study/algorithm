import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[] arr;
    static int[] d = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(0);

            return;
        }

        cal();

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    public static void cal() {
        for (int dx : d) {
            for (int dy : d) {
                int A = arr[0] + dx;
                int B = arr[1] + dy;
                int diff = B - A;
                int changes = Math.abs(dx) + Math.abs(dy);
                int prev = B;

                boolean isValid = true;

                for (int i = 2; i < N; i++) {
                    int expected = prev + diff;
                    int actual = arr[i];

                    if (Math.abs(actual - expected) > 1) {
                        isValid = false;

                        break;
                    }

                    changes += Math.abs(actual - expected);
                    prev = expected;
                }

                if (isValid) result = Math.min(result, changes);
            }
        }
    }
}
