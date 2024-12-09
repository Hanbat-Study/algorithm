import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, result;
    static boolean[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        card = new boolean[1000001];
        result = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            card[arr[i]] = true;
        }

        for (int num : arr) {
            for (int j = num * 2; j < 1000001; j += num) {
                if (card[j]) {
                    result[num]++;
                    result[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
