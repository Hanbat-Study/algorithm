import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, result;
    static int[][] arr;
    static int[][] copyArray;
    static int[][] box;
    static ArrayList<int[]> order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        arr = new int[N][M];
        copyArray = new int[N][M];
        box = new int[K][];
        order = orderNums(K);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                copyArray[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            box[i] = new int[]{r, c, s};
        }

        for (int i = 0; i < order.size(); i++) {
            arr = copyArr(copyArray);

            for (int j : order.get(i)) {
                int[] now = box[j];
                rotate(now[0], now[1], now[2]);
            }

            for (int[] a : arr) {
                int cnt = 0;
                for (int n : a) {
                    cnt += n;
                }
                result = Math.min(cnt, result);
            }
        }
        System.out.println(result);
    }

    private static void rotate(int R, int C, int S) {
        for (int s = 1; s <= S; s++) {
            int x = C - s;
            int y = R - s;
            int temp = arr[y][x];

            for (int i = y; i < y + 2 * s; i++) {
                arr[i][x] = arr[i + 1][x];
            }

            for (int i = x; i < x + 2 * s; i++) {
                arr[y + 2 * s][i] = arr[y + 2 * s][i + 1];
            }

            for (int i = y + 2 * s; i > y; i--) {
                arr[i][x + 2 * s] = arr[i - 1][x + 2 * s];
            }

            for (int i = x + 2 * s; i > x; i--) {
                arr[y][i] = arr[y][i - 1];
            }
            arr[y][x + 1] = temp;
        }
    }

    private static ArrayList<int[]> orderNums(int n) {
        ArrayList<int[]> a = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] permutation = new int[n];
        per(0, n, permutation, visited, a);
        return a;
    }

    private static void per(int index, int n, int[] permutation, boolean[] used, ArrayList<int[]> result) {
        if (index == n) {
            result.add(permutation.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                permutation[index] = i;
                used[i] = true;
                per(index + 1, n, permutation, used, result);
                used[i] = false;
            }
        }
    }

    private static int[][] copyArr(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }
}
