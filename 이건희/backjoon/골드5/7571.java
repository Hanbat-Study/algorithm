import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static ArrayList<Integer> list1, list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            list1.add(y);
            list2.add(x);
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int midY = list1.get(M / 2);
        int midX = list2.get(M / 2);

        for (int i = 0; i < M; i++) {
            result += Math.abs(list1.get(i) - midY) + Math.abs(list2.get(i) - midX);
        }

        System.out.println(result);
    }
}
