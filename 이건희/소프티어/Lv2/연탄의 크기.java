import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, arr[i]);
        }

        for (int i = 2; i <= maxNum; i++) {
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (i <= arr[j] && arr[j] % i == 0) cnt++;
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }
}
