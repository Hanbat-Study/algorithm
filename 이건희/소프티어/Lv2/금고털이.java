import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < N; i++) {
            if (arr[i][0] <= W) {
                W -= arr[i][0];
                result += arr[i][0] * arr[i][1];
            } else {
                if (W == 0) break;
                else {
                    result += arr[i][1] * W;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
