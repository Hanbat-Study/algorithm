import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, start;
    static long result;
    static int[] arr;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        start = 0;
        arr = new int[N];
        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int now = arr[i];

            map.put(now, map.getOrDefault(now, 0) + 1);

            while (1 < map.get(now)) {
                int startNum = arr[start];

                map.put(startNum, map.getOrDefault(startNum, 0) - 1);

                if (map.get(startNum) == 0) map.remove(startNum);

                start++;
            }

            result += (i - start + 1);
        }
        System.out.println(result);
    }
}
