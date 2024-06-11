import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1722 {
    static int n;
    static long[] factorial;
    static boolean[] visited;

    // 팩토리얼 값 미리 계산
    static void preCalculateFactorial() {
        factorial = new long[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        preCalculateFactorial();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());

        if (command == 1) {
            long k = Long.parseLong(st.nextToken());
            findPermutation(k);
        } else {
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }
            findOrder(sequence);
        }
    }

    // 주어진 순서에 해당하는 순열 찾기
    static void findPermutation(long k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                if (factorial[n-i-1] < k) {
                    k -= factorial[n-i-1];
                } else {
                    sb.append(j).append(" ");
                    visited[j] = true;
                    break;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    // 주어진 순열의 순서 찾기
    static void findOrder(int[] sequence) {
        long order = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < sequence[i]; j++) {
                if (!visited[j]) {
                    order += factorial[n-i-1];
                }
            }
            visited[sequence[i]] = true;
        }
        System.out.println(order);
    }
}
