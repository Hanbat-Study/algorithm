import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, now;
    static int[][] arr, bridge;
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        now = 2;
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    bfs(i, j);
                    now++;
                }
            }
        }

        bridge = new int[now][now];
        for (int i = 0; i < now; i++) {
            Arrays.fill(bridge[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    check(i, j);
                }
            }
        }

        boolean[] visited = new boolean[now];
        int[] minEdge = new int[now];


        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[2] = 0;
        int result = 0;
        int c = 2;
        for (c = 2; c < now; c++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for (int i = 2; i < now; i++) {
                if (!visited[i] && minEdge[i] < min) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            if (minVertex == -1) break;
            result += min;
            visited[minVertex] = true;

            for (int i = 2; i < now; i++) {
                if (!visited[i] && bridge[minVertex][i] != Integer.MAX_VALUE && bridge[minVertex][i] < minEdge[i]) {
                    minEdge[i] = bridge[minVertex][i];
                }
            }
        }

        System.out.println(c == now ? result : -1);
    }

    private static void check(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int dy = y + dis[i][0];
            int dx = x + dis[i][1];
            int cnt = 0;

            while (0 <= dy && dy < N && 0 <= dx && dx < M) {
                if (arr[dy][dx] != 0 && arr[dy][dx] != arr[y][x] && 2 <= cnt) {
                    int island1 = arr[y][x];
                    int island2 = arr[dy][dx];
                    bridge[island1][island2] = bridge[island2][island1] = Math.min(bridge[island1][island2], cnt);
                    break;
                } else if (arr[dy][dx] != 0) break;

                dy += dis[i][0];
                dx += dis[i][1];
                cnt++;
            }
        }
    }


    private static void bfs(int y, int x) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        arr[y][x] = now;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dy = current[0] + dis[i][0];
                int dx = current[1] + dis[i][1];

                if (0 <= dy && dy < N && 0 <= dx && dx < M && arr[dy][dx] == 1) {
                    queue.offer(new int[]{dy, dx});
                    arr[dy][dx] = now;
                }
            }
        }
    }


}
