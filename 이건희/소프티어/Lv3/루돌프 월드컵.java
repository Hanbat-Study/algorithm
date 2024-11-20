import java.io.*;
import java.util.*;

public class Main {
    static double result;
    static int[] arr, score;
    static int[][] match = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};
    static char[] games;
    static char[] c = {'W', 'D', 'L'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        arr = new int[4];
        games = new char[6];
        result = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        per(0);

        System.out.printf("%.3f\n", result * 100);
    }

    public static void per(int cnt) {
        if (cnt == 6) {
            cal();

            return;
        }

        for (int i = 0; i < 3; i++) {
            games[cnt] = c[i];
            per(cnt + 1);
        }
    }

    public static void cal() {
        score = new int[4];
        double num = 1;

        for (int i = 0; i < 6; i++) {
            if (games[i] == 'W') {
                score[match[i][0]] += 3;
            } else if (games[i] == 'D') {
                score[match[i][0]] += 1;
                score[match[i][1]] += 1;
            } else {
                score[match[i][1]] += 3;
            }
        }

        int cnt = 0;

        for (int i = 1; i < 4; i++) {
            if (score[0] < score[i]) cnt++;
        }

        if (1 < cnt) return;

        for (int i = 0; i < 6; i++) {
            if (games[i] == 'W') {
                num *= (double) (4 * arr[match[i][0]]) / (5 * arr[match[i][0]] + 5 * arr[match[i][1]]);
            } else if (games[i] == 'D') {
                num *= (double) (arr[match[i][0]] + arr[match[i][1]]) / (5 * arr[match[i][0]] + 5 * arr[match[i][1]]);
            } else {
                num *= (double) (4 * arr[match[i][1]]) / (5 * arr[match[i][0]] + 5 * arr[match[i][1]]);
            }
        }
        result += num;
    }
}
