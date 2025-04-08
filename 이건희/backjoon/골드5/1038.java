import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (N <= 9) {
            System.out.println(N);

            return;
        }
        else if (1022 < N) {
            System.out.println(-1);

            return;
        }

        for (int i = 0; i < 10; i++) {
            cal(i, 1);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    public static void cal(long num, int idx) {
        if (10 < idx) return;

        list.add(num);

        for (int i = 0; i < num % 10; i++) {
            cal(num * 10 + i, idx + 1);
        }
    }
}
