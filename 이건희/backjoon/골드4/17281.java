import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, out, result;
    static int[] hitters;
    static int[][] innings;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        out = 0;

        innings = new int[N][9];
        hitters = new int[9];
        check = new boolean[9];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        hitters[3] = 0;
        check[3] = true;

        comb(1);

        System.out.println(result);
    }

    private static void comb(int cnt) {
        if (cnt == 9) {
            int score = game();

            result = Math.max(result, score);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!check[i]) {
                check[i] = true;
                hitters[i] = cnt;

                comb(cnt + 1);

                check[i] = false;
            }
        }
    }

    private static int game() {
        int score = 0;
        int now = 0;

        for (int i = 0; i < N; i++) {
            int out = 0;
            int cnt = 0;

            boolean[] base = new boolean[3];

            while (out < 3) {
                if (innings[i][hitters[now]] == 0) {
                    out++;
                } else if (innings[i][hitters[now]] == 1) {
                    if (base[2]) {
                        cnt++;
                        base[2] = false;
                    }

                    if (base[1]) {
                        base[2] = true;
                        base[1] = false;
                    }

                    if (base[0]) {
                        base[1] = true;
                    }

                    base[0] = true;
                } else if (innings[i][hitters[now]] == 2) {
                    if (base[2]) {
                        cnt++;
                        base[2] = false;
                    }

                    if (base[1]) {
                        cnt++;
                    }

                    if (base[0]) {
                        base[2] = true;
                        base[0] = false;
                    }

                    base[1] = true;
                } else if (innings[i][hitters[now]] == 3) {
                    if (base[2]) {
                        cnt++;
                    }

                    if (base[1]) {
                        cnt++;
                        base[1] = false;
                    }

                    if (base[0]) {
                        cnt++;
                        base[0] = false;
                    }

                    base[2] = true;
                } else if (innings[i][hitters[now]] == 4) {
                    if (base[2]) {
                        cnt++;
                        base[2] = false;
                    }

                    if (base[1]) {
                        cnt++;
                        base[1] = false;
                    }

                    if (base[0]) {
                        cnt++;
                        base[0] = false;
                    }

                    cnt++;
                }

                now++;

                if (9 <= now) {
                    now = 0;
                }
            }

            score += cnt;
        }

        return score;
    }
}
