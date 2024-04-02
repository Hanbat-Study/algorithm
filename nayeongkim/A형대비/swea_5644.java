import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5644 {
    private static int m, A, res;
    private static int[] a, b, moveA, moveB;
    private static  int[][] ap;
    private static int[] dr = {0, -1, 0, 1, 0};
    private static int[] dc = {0, 0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            ap = new int[A][4];
            a = new int[2];
            b = new int[2];
            a[0] = 1; a[1] = 1;
            b[0] = 10; b[1] = 10;
            moveA = new int[m + 1];
            moveB = new int[m + 1];
            StringTokenizer stA = new StringTokenizer(br.readLine());
            StringTokenizer stB = new StringTokenizer(br.readLine());
            for (int i = 1; i < m + 1; i++) {
                moveA[i] = Integer.parseInt(stA.nextToken());
                moveB[i] = Integer.parseInt(stB.nextToken());
            }
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                ap[i][0] = Integer.parseInt(st.nextToken());//x
                ap[i][1] = Integer.parseInt(st.nextToken());//y
                ap[i][2] = Integer.parseInt(st.nextToken());//c
                ap[i][3] = Integer.parseInt(st.nextToken());//p
            }
            move();
            System.out.println("#"+ t + " "+ res);
        }
    }

    private static void move() {
        res = 0;
        for (int d = 0; d< m + 1; d++) {
            a[0] += dc[moveA[d]];
            a[1] += dr[moveA[d]];
            b[0] += dc[moveB[d]];
            b[1] += dr[moveB[d]];

            res += getCharge();
        }
    }

    private static int getCharge() {
        int max = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int sum = 0;
                int sumA = getDist(i,a[0], a[1]);
                int sumB = getDist(j,b[0], b[1]);

                if (i !=j) sum = sumA + sumB;
                else {
                    sum = Math.max(sumA, sumB);
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    private static int getDist(int i, int x, int y) {
        return Math.abs(x - ap[i][0]) + Math.abs(y - ap[i][1]) <= ap[i][2] ? ap[i][3] : 0;
    }
}
