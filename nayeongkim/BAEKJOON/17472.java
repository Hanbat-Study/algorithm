import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_17472 {
    static class Island implements Comparable<Island> {
        int from, to, weight;

        public Island(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Island o) {
            return this.weight - o.weight;
        }
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int n, m, idx;
    static int[][] map;
    static int[] parent;
    static boolean[][] visited;
    static ArrayList<Island> islands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 매기기
        idx = 2; // 섬 번호는 2부터 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    numberIslands(i, j, idx++);
                }
            }
        }

        // 각 섬 사이의 다리 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 1) {
                    makeBridge(i, j);
                }
            }
        }

        // 크루스칼 알고리즘을 위한 사전 준비
        parent = new int[idx];
        for (int i = 2; i < idx; i++) {
            parent[i] = i;
        }

        // 크루스칼 알고리즘 실행
        int result = 0;
        Collections.sort(islands);
        for (Island island : islands) {
            if (union(island.from, island.to)) {
                result += island.weight;
            }
        }

        // 모든 섬이 연결되었는지 확인
        int root = find(2);
        for (int i = 3; i < idx; i++) {
            if (find(i) != root) {
                result = -1;
                break;
            }
        }

        System.out.println(result == -1 ? -1 : result);
    }

    private static void numberIslands(int r, int c, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        map[r][c] = idx;
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = idx;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static void makeBridge(int r, int c) {
        int base = map[r][c];
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d], len = 0;
            while (true) {
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == base) break; // 범위를 벗어나거나 같은 섬에 도달한 경우 중단
                if (map[nr][nc] > 1) { // 다른 섬에 도달한 경우
                    if (len > 1) { // 길이가 2 이상인 경우에만 다리 추가
                        islands.add(new Island(base, map[nr][nc], len));
                    }
                    break;
                }
                nr += dr[d];
                nc += dc[d];
                len++;
            }
        }
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}
