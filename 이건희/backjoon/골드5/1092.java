import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result, now;
    static ArrayList<Integer> arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        arr1 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr1.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        arr2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr2.add(Integer.parseInt(st.nextToken()));
        }

        arr1.sort(Collections.reverseOrder());
        arr2.sort(Collections.reverseOrder());

        if (arr1.get(0) < arr2.get(0)) {
            System.out.println(-1);

            return;
        }

        while (!arr2.isEmpty()) {
            now = 0;

            for (int i = 0; i < N;) {
                if (arr2.get(now) <= arr1.get(i)) {
                    arr2.remove(now);
                    i++;
                } else now++;

                if (now == arr2.size()) break;
            }


            result++;
        }

        System.out.println(result);
    }
}
