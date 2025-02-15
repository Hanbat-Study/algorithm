import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int N;
    static int[] arr;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        for (int i = N - 1; 0 <= i; i--) {
            for (int j = 0; j < N; j++) {
                int num = arr[i] - arr[j];

                if (set.contains(num)) {
                    System.out.println(arr[i]);

                    return;
                }
            }
        }
    }
}
