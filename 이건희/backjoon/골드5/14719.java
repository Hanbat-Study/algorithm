import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int H, W, result;
    static int[] arr, arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        arr1 = new int[W];
        arr2 = new int[W];
        result = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr1[0] = arr[0];
        arr2[W - 1] = arr[W - 1];

        for (int i = 1; i < W; i++) {
            arr1[i] = Math.max(arr1[i - 1], arr[i]);
        }

        for (int i = W - 2; i >= 0; i--) {
            arr2[i] = Math.max(arr2[i + 1], arr[i]);
        }

        for (int i = 0; i < W; i++) {
            result += Math.min(arr1[i], arr2[i]) - arr[i];
        }

        System.out.println(result);
    }
}
