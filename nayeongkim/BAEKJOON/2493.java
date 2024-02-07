import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_2493 {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        result = new int[N];
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0] < height) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek()[1] + 1;
            } else result[i] = 0;
            stack.push(new int[] { height, i});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]+" ");
        }
        System.out.println(sb);
    }
}