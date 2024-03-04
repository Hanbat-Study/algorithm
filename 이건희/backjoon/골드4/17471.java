import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[] population, arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        population = new int[N];
        arr = new int[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n  = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        comb(0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(result);
    }

    private static void comb(int now) {
        if (now == N) {
            if (check()) {
                int cntA = 0;
                int cntB = 0;

                for (int i = 0; i < N; i++) {
                    if (arr[i] == 1) {
                        cntA += population[i];
                    } else cntB += population[i];
                }

                result = Math.min(result, Math.abs(cntA - cntB));
            }
            return;
        }

        arr[now] = 1;
        comb(now + 1);
        arr[now] = 0;
        comb(now + 1);
    }

    private static boolean check() {
        visited = new boolean[N];
        int a = -1;
        int b = -1;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                a = i;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                b = i;
                break;
            }
        }

        if (a == -1 || b == -1) return false;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(a);
        visited[a] = true;

        while (!queue.isEmpty()) {
            int d = queue.poll();

            for (int i = 0; i < list.get(d).size(); i++) {
                int next = list.get(d).get(i);
                if (!visited[next] && arr[next] == 1) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        queue.offer(b);
        visited[b] = true;

        while (!queue.isEmpty()) {
            int d = queue.poll();

            for (int i = 0; i < list.get(d).size(); i++) {
                int next = list.get(d).get(i);
                if (!visited[next] && arr[next] == 0) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        for (boolean bool : visited) {
            if (!bool) return false;
        }
        return true;
    }
}
