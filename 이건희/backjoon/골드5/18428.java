import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static boolean flag;
    static ArrayList<int[]> students, teachers;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flag = false;
        map = new char[N][N];
        students = new ArrayList<>();
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = s[j].charAt(0);

                if (map[i][j] == 'T') teachers.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 'X') continue;

                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < N; l++) {
                        if (map[k][l] != 'X' || (i == k && j == l)) continue;

                        for (int m = 0; m < N; m++) {
                            for (int n = 0; n < N; n++) {
                                if (map[m][n] != 'X' || (i == m && j == n) || (k == m && l == n)) continue;

                                cal(i, j, k, l, m, n);

                                if (flag) {
                                    System.out.println("YES");

                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("NO");
    }

    public static void cal(int y1, int x1, int y2, int x2, int y3, int x3) {
        map[y1][x1] = 'O';
        map[y2][x2] = 'O';
        map[y3][x3] = 'O';

        boolean check = true;

        for (int[] teacher : teachers) {
            if (!checkVisibility(teacher[0], teacher[1])) {
                check = false;

                break;
            }
        }

        if (check) {
            flag = true;

            return;
        }

        map[y1][x1] = 'X';
        map[y2][x2] = 'X';
        map[y3][x3] = 'X';
    }

    public static boolean checkVisibility(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;

            while (true) {
                ny += d[i][0];
                nx += d[i][1];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;

                if (map[ny][nx] == 'O') break;

                if (map[ny][nx] == 'S') return false;
            }
        }

        return true;
    }
}
