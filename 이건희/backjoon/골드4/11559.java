import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int result;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = 0;
        arr = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();

            for (int j = 0; j < 6; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        check();

        System.out.println(result);
    }

    public static void check() {
        boolean c = true;
        visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] != '.' && !visited[i][j]) {
                    if (4 <= cal(i, j)) {
                        c = false;
                    }
                }
            }
        }

        if (!c) {
            result++;
            down();
            check();
        }
    }

    public static void down() {
        for (int i = 0; i < 6; i++) {
            ArrayList<Character> list = new ArrayList<>();

            for (int j = 11; 0 <= j; j--) {
                if (arr[j][i] != '.') {
                    list.add(arr[j][i]);
                }
            }

            for (int j = 11; j >= 0; j--) {
                if (j > 11 - list.size()) {
                    arr[j][i] = list.get(11 - j);
                } else {
                    arr[j][i] = '.';
                }
            }
        }
    }

    public static int cal(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();
        q.add(new int[]{y, x});
        list.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int dy = poll[0];
            int dx = poll[1];


            for (int i = 0; i < 4; i++) {
                int ny = dy + d[i][0];
                int nx = dx + d[i][1];

                if (0  <= ny && ny < 12 && 0 <= nx && nx < 6 && !visited[ny][nx] && arr[ny][nx] == arr[dy][dx]) {
                    q.add(new int[]{ny, nx});
                    list.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

        if (4 <= list.size()) {
            for (int i = 0; i < list.size(); i++) {
                int ny = list.get(i)[0];
                int nx = list.get(i)[1];
                arr[ny][nx] = '.';
            }
        }

        return list.size();
    }
}
