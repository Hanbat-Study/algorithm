import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int snowman = arr[i] + arr[j];
                int start = 0;
                int end = N - 1;

                while (start < end) {
                    if (start == i || start == j) {
                        start++;

                        continue;
                    } else if (end == i || end == j) {
                        end--;

                        continue;
                    }

                    int compareSnowman = arr[start] + arr[end];
                    result = Math.min(result, Math.abs(compareSnowman - snowman));

                    if (snowman < compareSnowman) end--;
                    else if (compareSnowman < snowman) start++;
                    else {
                        System.out.println(0);

                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
