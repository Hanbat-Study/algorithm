import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Soulution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        int[] d_y = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] d_x = {-1, 1, -1, 0, 1, -1, 1, 0};

        for (int tc = 1; tc <= T; tc++) {
            int max_water = 1;
            int N = Integer.parseInt(br.readLine());
            String[][] strings = new String[N][N];
            for (int i = 0; i < N; i++) {
                strings[i]= br.readLine().split(" ");
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (strings[i][j].equals("W")) {
                        int water = 0;
                        for (int d = 0; d < 8; d++) {
                            int nx = i + d_x[d];
                            int ny = j + d_y[d];
                            if (0 <= nx && nx < N && 0 <= ny && ny < N && strings[nx][ny].equals("W")) {
                                water++;
                            }
                        }
                        max_water = Math.max(max_water, water);
                    }

                }

            }
            System.out.printf("#%d %d\n",tc, max_water);
        }
    }
}