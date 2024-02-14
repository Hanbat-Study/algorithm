import java.util.*;
import java.io.*;

class Main_2630 {
    static int[][] map;
    static int blue, white;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0, 0, n);
        System.out.println(white);
        System.out.println(blue);

    }
    private static void search(int i, int j, int n) {
        int sum = 0;
        for (int r = i; r <i +n; r++) {
            for (int c = j; c < j + n; c++) {
                sum += map[r][c];
            }
        }
        if (sum == n*n) blue++;
        else if (sum == 0) white++;
        else {
            int half = n /2;
            search(i, j, half);
            search(i, j + half, half);
            search(i + half, j, half);
            search(i + half, j + half, half);
        }

    }
}