import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rooms = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            rooms[i][0] = S;
            rooms[i][1] = T;
        }

        Arrays.sort(rooms, Comparator.comparingInt((int[] a) -> a[1]));

        int result = 0;
        int curTime = 0;

        for (int i = 0; i < N; i++) {
            if (rooms[i][0] < curTime) continue;
            else {
                result++;
                curTime = rooms[i][1];
            }
        }

        System.out.println(result);
    }
}
