import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] cake = new int[L + 1];
        int result = 0 ;
        int resultIndex = 0;
        int max = 0;
        int maxIndex = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = 0;

            if (end - start > max) {
                max = end - start;
                maxIndex = i;
            }

            for (int j = start; j <= end; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                    cnt++;
                }
            }

            if (cnt > result) {
                result = cnt;
                resultIndex = i;
            }
        }
        System.out.println(maxIndex);
        System.out.println(resultIndex);
    }
}
