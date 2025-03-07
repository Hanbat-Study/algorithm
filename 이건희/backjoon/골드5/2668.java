import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited, check;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                check = new boolean[N + 1];

                cal(i, i);
            }
        }

        System.out.println(list.size());

        Collections.sort(list);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static void cal(int start, int now) {
        if (check[now]) {
            if (now == start) {
                list.add(start);
            }
            
            return;
        }

        check[now] = true;

        cal(start, arr[now]);
    }
}
