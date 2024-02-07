import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int  i = 0; i < R; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) updown();
            else if (n == 2) leftright();
            else if (n == 3) {

                map = right90();

            }
            else if (n == 4) {

                map = left90();
            }
            else if (n == 5) rotateright();
            else rotateleft();
        }
        printMap(map);

    }

    private static void rotateleft() {
        for(int i = 0; i< N/2; i++) {
            for (int j = 0; j <M/2; j++) {
                int tmp1 = map[i][j];
                int tmp2 = map[i][M/2 + j];
                int tmp3 = map[N/2 + i][M/2 + j];
                map[N/2 + i][M/2 + j] = map[N/2 + i][j];
                map[i][M/2 + j] = tmp3;
                map[i][j] = tmp2;
                map[N/2 + i][j] = tmp1;
            }
        }

    }

    private static void rotateright() {
        for(int i = 0; i< N/2; i++) {
            for (int j = 0; j <M/2; j++) {
                int tmp1 = map[i][j];
                int tmp2 = map[i][M/2 + j];
                int tmp3 = map[N/2 + i][M/2 + j];
                map[i][j] = map[N/2 + i][j];
                map[i][M/2 + j] = tmp1;
                map[N/2 + i][M/2 + j] = tmp2;
                map[N/2 + i][j] = tmp3;
            }
        }


    }

    private static int[][] left90() {
        int[][]map2 = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = M -1; j >= 0; j--) {
                map2[M-1-j][i] = map[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        return map2;

    }

    private static int[][] right90() {
        int[][]map2 = new int[M][N];
        for (int i = N-1; i >=0; i--) {
            for (int j = 0; j <M; j++) {

                map2[j][N-1-i] = map[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        return map2;

    }

    private static void leftright() {

        for (int i = 0; i< N; i++) {
            for (int j = 0; j <M / 2; j++) {
                int tmp = map[i][M - 1 - j];
                map[i][M - 1 - j] = map[i][j];
                map[i][j] = tmp;
            }
        }


    }

    private static void updown() {
//        int[][] map2 = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            System.arraycopy(map[i], 0, map2[i], 0, M);
//        }
        for (int i = 0; i< N/2; i++) {
            for (int j = 0; j <M; j++) {
                int tmp = map[N - 1 - i][j];
                map[N - i - 1][j] = map[i][j];
                map[i][j] = tmp;
            }
        }

    }

    private static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        //stream<int[]>
        Arrays.stream(map).forEach(r -> {
            //stream<int>
            Arrays.stream(r).forEach(v -> sb.append(v + " "));
            sb.append("\n");
        });
        System.out.println(sb);

    }

}