import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution4 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int cnt = 1;
            int x = 0;
            int y = -1;
            int d = 0;
            while (cnt <= N * N) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 0) {
                    arr[nx][ny] = cnt++;
                    x = nx;
                    y = ny;
                } else {
                    d = (d + 1) % 4;

                }

            }
            System.out.println("#"+test_case);
            for(int i = 0; i<N; i++){
               for(int j = 0; j<N; j++){
                   System.out.print(arr[i][j]);
               }
                System.out.println();
            }


        }
    }
}