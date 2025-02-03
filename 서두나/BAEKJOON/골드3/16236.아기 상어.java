import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r, c, dist;

        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int n;
    static int[][] arr;
    static boolean[][] visited;

    static int[] drs = { -1, 0, 0, 1 }; // 북, 서, 동, 남
    static int[] dcs = { 0, -1, 1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        int r = -1, c = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    arr[i][j] = 0;
                    r = i;
                    c = j;
                }
            }
        }

        int size = 2;
        int cnt = 0;
        int time = 0;

        while (true) {
            Node fish = findFish(r, c, size);
            if (fish == null) {
                break;
            }

            // 물고기 먹기
            r = fish.r;
            c = fish.c;
            time += fish.dist;

            cnt++;
            if (size == cnt) {
                size++;
                cnt = 0;
            }
            arr[r][c] = 0; // 먹은 물고기 위치는 빈칸으로 설정
        }

        System.out.println(time);
    }

    static Node findFish(int r, int c, int size) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new Node(r, c, 0));
        visited[r][c] = true;

        int minDist = Integer.MAX_VALUE;
        Node closestFish = null;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 물고기 찾기
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + drs[i];
                int nc = cur.c + dcs[i];

                // 범위 벗어나거나, 지나갈 수 없는 칸일 경우
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] || arr[nr][nc] > size) {
                    continue;
                }

                visited[nr][nc] = true;

                // 물고기를 찾은 경우
                if (arr[nr][nc] > 0 && arr[nr][nc] < size) {
                    // 가장 가까운 물고기 찾기
                    if (cur.dist + 1 < minDist) {
                        minDist = cur.dist + 1;
                        closestFish = new Node(nr, nc, minDist);
                    } else if (cur.dist + 1 == minDist) {
                        if (nr < closestFish.r || (nr == closestFish.r && nc < closestFish.c)) {
                            closestFish = new Node(nr, nc, minDist);
                        }
                    }
                }
                q.offer(new Node(nr, nc, cur.dist + 1));
            }
        }

        return closestFish;
    }
}
