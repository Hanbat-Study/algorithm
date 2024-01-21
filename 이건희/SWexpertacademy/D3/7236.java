import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        int[][] dr = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int result = 1;
            String[][] arr = new String[N][];

            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().split(" ");
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cnt = 0;
                    if (arr[i][j].equals("W")) {
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dr[k][1];
                            int ny = j + dr[k][0];
                            if (0 <= nx && nx < N && 0 <= ny && ny < N && arr[ny][nx].equals("W")) {
                                cnt++;
                            }
                        }
                        result = Math.max(cnt, result);
                    }
                }
            }

            System.out.printf("#%d %s\n", test_case, result);
        }
    }
}
