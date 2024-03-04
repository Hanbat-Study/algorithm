import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Main {
	static class CCTV {
	    int x, y, type;

	    CCTV(int x, int y, int type) {
	        this.x = x;
	        this.y = y;
	        this.type = type;
	    }
	}
    static int N, M;
    static int[][] map;
    static ArrayList<CCTV> cctvs = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};
    static int[][][] directions = {
            {{0}},
            {{0},{1},{2},{3}},//1번
            {{0, 2}, {1, 3}}, // 2번 
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 
            {{0, 1, 2, 3}} // 5번
    };
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs(int index, int[][] prevMap) {
        if (index == cctvs.size()) {
            answer = Math.min(answer, countBlindSpots(prevMap));
            return;
        }

        CCTV cctv = cctvs.get(index);
        int[][] tempMap = new int[N][M];
        for (int[] dir : directions[cctv.type]) {
        
            for (int i = 0; i < N; i++) {
                System.arraycopy(prevMap[i], 0, tempMap[i], 0, M);
            }
      
            for (int d : dir) {
                int nx = cctv.x, ny = cctv.y;
                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || tempMap[nx][ny] == 6) break;
                    if (tempMap[nx][ny] == 0) tempMap[nx][ny] = -1; 
                }
            }
            dfs(index + 1, tempMap);
        }
    }

    static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}
