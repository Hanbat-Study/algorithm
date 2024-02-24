import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_17281 {
    static int[][] players,games;
    static int n, res;
    static int[] order;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        players = new int[n][9];
        games = new int[n][9];
        isSelected = new boolean[9];
        order = new int[9];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        order[3] = 0;
        isSelected[3] = true;
        perm(1);
        System.out.println(res);
    }

    private static void perm(int cnt) {
        if (cnt == 9) {
            res = Math.max(res, play());
            return;
        }
        for (int i = 0; i <9; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            order[i] = cnt;
            perm(cnt + 1);
            isSelected[i] = false;
        }

    }

    private static int play() {
        int sum = 0;
        int idx = 0;
        for (int r = 0; r < n; r++) {
            boolean[] base = new boolean[4];
            int curScore = 0;
            int out = 0;
            while (out < 3) {
                switch (players[r][order[idx]]) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        if (base[3]) {
                            curScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    case 2:
                        if (base[3]) {
                            curScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            curScore++;
                        }
                        if (base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    case 3:
                        if (base[3]) {
                            curScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            curScore++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            curScore++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    case 4:
                        if (base[3]) {
                            curScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            curScore++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            curScore++;
                            base[1] = false;
                        }
                        curScore++;
                        break;
                }
                idx++;
                if (idx >= 9) idx = 0;
            }
            sum += curScore;
        }
        return sum;
    }
}