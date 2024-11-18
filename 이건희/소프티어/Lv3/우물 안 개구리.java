import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static int[] arr;
    static HashSet<Integer>[] connections;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        connections = new HashSet[N];
        result = N;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            connections[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            connections[a].add(b);
            connections[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            for (int j : connections[i]) {
                if (arr[i] <= arr[j]) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
