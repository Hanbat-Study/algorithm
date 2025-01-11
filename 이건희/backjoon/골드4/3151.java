import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) {
            if (0 < arr[i]) break;

            int start = i + 1;
            int end = N - 1;

            while (start < end) {
                if (start == i) {
                    start++;

                    continue;
                } else if (end == i) {
                    end--;

                    continue;
                }

                int r = 1;
                int l = 1;
                int sum = arr[start] + arr[end] + arr[i];

                if (sum == 0) {
                    if (arr[start] == arr[end]) {
                        int n = end - start + 1;
                        result += n * (n - 1) / 2;

                        break;
                    }

                    while (start + 1 < end && arr[start] == arr[start + 1]) {
                        start++;
                        l++;
                    }

                    while (start < end - 1 && arr[end] == arr[end - 1]) {
                        end--;
                        r++;
                    }

                    result += l * r;
                }

                if (sum < 0) {
                    start++;
                } else end--;
            }
        }

        System.out.println(result);
    }
}
