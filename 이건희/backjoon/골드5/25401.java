import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = N - 1;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int diff = arr[j] - arr[i];
                int dist = j - i;

                int d = diff / dist;
                int count = 0;

                for (int n = 0; n < N; n++) {
                    int a1 = arr[i];
                    int an = a1 + (n - i) * d;
                    
                    if (arr[n] != an) count++;
                }

                result = Math.min(result, count);
            }
        }

        System.out.println(result);
    }
}
