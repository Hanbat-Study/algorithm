import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N , minNum, maxNum;
    static char[][] arr;
    static int[][] d = {{0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minNum = Integer.MAX_VALUE;
        maxNum = Integer.MIN_VALUE;
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }

        go(0, 0, arr[0][0] - '0', ' ');

        System.out.println(maxNum + " " + minNum);
    }

    public static void go(int y, int x, int sum, char c) {
        if (y == N - 1 && x == N - 1) {
            minNum = Math.min(minNum, sum);
            maxNum = Math.max(maxNum, sum);

            return;
        }

        for (int i = 0; i < 2; i++) {
            int dy = y + d[i][0];
            int dx = x + d[i][1];

            if (0 <= dy && dy < N && 0 <= dx && dx < N) {
                if (arr[dy][dx] == '+') go(dy, dx, sum, '+');
                else if (arr[dy][dx] == '-') go(dy, dx, sum, '-');
                else if (arr[dy][dx] == '*') go(dy, dx, sum, '*');
                else {
                    if (c == '+') go(dy, dx, sum + (arr[dy][dx] - '0'), ' ');
                    else if (c == '-') go(dy, dx, sum - (arr[dy][dx] - '0'), ' ');
                    else if (c == '*') go(dy, dx, sum * (arr[dy][dx] - '0'), ' ');
                }
            }
        }
    }
}
