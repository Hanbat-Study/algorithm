import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_4014 {
    static int n, x, res;
    static  boolean[] isSelected;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            res = 0;
            //가로 검사
            for (int i = 0; i < n; i++) {
                if (canBuild(map[i])) res++;
            }
            //세로검사
            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = map[i][j];
                }
                if (canBuild(col)) res++;
            }
            System.out.println("#"+ t+ " "+ res);
        }
    }

    private static boolean canBuild(int[] line) {
       isSelected = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            if (line[i] == line[i  +1]) continue;
            if (Math.abs(line[i] - line[i +1]) > 1) return false;
            //올라간 경우 -> 그 전 거들을 봐야함
            if (line[i] < line[i + 1]) {
                for (int j = 0; j < x; j++) {
                    if (i - j < 0 || line[i] != line[i - j] || isSelected[i - j]) return false;
                    isSelected[i - j] = true;
                }
            }
            //내려간 경우 -> 그 후의 것들을 봐야함
            else {
                for (int j = 1; j <= x; j++) {
                    if (i + j >=n || line[i + 1] != line[i + j]|| isSelected[i + j]) return false;
                    isSelected[i + j] = true;
                }
            }
        }
        return true;
    }


}