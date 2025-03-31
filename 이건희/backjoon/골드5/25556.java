import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean flag;
    static int[] arr;
    static Stack<Integer> st1, st2, st3, st4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flag = true;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st1 = new Stack<>();
        st2 = new Stack<>();
        st3 = new Stack<>();
        st4 = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!flag) break;

            int now = arr[i];

            if (push(now, st1)) st1.push(now);
            else if (push(now, st2)) st2.push(now);
            else if (push(now, st3)) st3.push(now);
            else if (push(now, st4)) st4.push(now);
            else flag = false;
        }

        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static boolean push(int now, Stack<Integer> st) {
        return st.empty() || st.peek() < now;
    }
}
