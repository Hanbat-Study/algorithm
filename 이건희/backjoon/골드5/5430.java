import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque;
    static boolean flag;
    static StringBuilder result;
    static String[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();
            flag = true;
            result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            cal();

            System.out.println(result);
        }
    }

    public static void cal() {
        for (String com : p) {
            if (com.equals("R")) flag = !flag;
            else {
                if (deque.isEmpty()) {
                    result = new StringBuilder("error");

                    return;
                }

                if (flag) deque.poll();
                else deque.pollLast();
            }
        }

        result.append("[");

        int num = deque.size();

        for (int i = 0; i < num; i++) {
            if (i < num - 1) {
                if (flag) result.append(deque.poll()).append(",");
                else result.append(deque.pollLast()).append(",");
            } else {
                if (flag) result.append(deque.poll());
                else result.append(deque.pollLast());
            }
        }

        result.append("]");
    }
}
