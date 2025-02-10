import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, result;
    static int[] arr;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = bfs();

        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        String s = Arrays.toString(arr);
        int[] sortedArray = arr.clone();

        queue.add(arr.clone());
        cq.add(0);
        visited.add(s);
        Arrays.sort(sortedArray);

        String target = Arrays.toString(sortedArray);

        while (!queue.isEmpty()) {
            int[] currentArr = queue.poll();
            int count = cq.poll();
            String currentState = Arrays.toString(currentArr);

            if (currentState.equals(target)) {
                return count;
            }

            for (int i = 0; i <= N - K; i++) {
                int[] nextArr = currentArr.clone();
                reverseSubarray(nextArr, i, i + K - 1);
                String nextState = Arrays.toString(nextArr);

                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(nextArr);
                    cq.add(count + 1);
                }
            }
        }

        return -1;
    }

    public static void reverseSubarray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
