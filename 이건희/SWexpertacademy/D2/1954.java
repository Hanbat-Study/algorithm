import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int num = 1;
            int d = 0;
            int arr[][] = new int[N][N];
            int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = -1, y = 0;

            while (num <= N * N) {
                int nx = x + dir[d][1];
                int ny = y + dir[d][0];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && arr[ny][nx] == 0) {
                    arr[ny][nx] = num++;
                    x = nx;
                    y = ny;
                } else {
                    d = (d + 1) % 4;
                }
            }

            System.out.printf("#%d\n", test_case);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
