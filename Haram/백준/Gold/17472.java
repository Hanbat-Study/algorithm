import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    static int N, M, map[][], iCnt, parents[], answer;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static List<Edge> edgeList;
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        input();
        
        // 섬의 갯수 세기 // 섬에 번호를 붙일 때 2부터 시작하므로 -1한 값이 섬의 갯수이다.
        iCnt = countIsland() - 2;
        
        // 다리를 세워 나라를 만들겠다!
        makeCountry();
        
        // 세워진 다리로 최소 신장 트리 만들어서 가중치 계산
        MST();
        
        boolean flag = true;
        int root = find(0);
        for(int i = 1; i < iCnt; i++) {
        	if(root != find(i)) flag = false;
        }
        System.out.println(flag ? answer : -1);
    }
    
    private static void MST() {
        Collections.sort(edgeList);
        
        make();
        
        int cnt = 0;
        for(Edge edge : edgeList) {
            if(!union(edge.from, edge.to)) continue;
            answer += edge.weight;
            if(++cnt == iCnt - 1) break;
        }
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    private static int find(int a) {
        if(a == parents[a]) return a;
        else return parents[a] = find(parents[a]);
    }

    private static void make() {
        // 섬 갯수길이 대표자 배열 만들기
        parents = new int[iCnt];
        for(int i = 0; i < iCnt; i++) 
            parents[i] = i;
    }

    private static void makeCountry() {
        edgeList = new ArrayList<>();    
        
        // 가로로 세울 수 있는 다리
        for(int i = 0; i < N; i++) {
            buildTheBridge(i, 0, true);
        }
        
        // 세로로 세울 수 있는다리
        for(int i = 0; i < M; i++) {
            buildTheBridge(0, i, false);            
        }
    }
    
    private static void buildTheBridge(int x, int y, boolean isVertical) {
        int from = -1, to = -1, weight = 0;
        
        while(true) {
            // 섬이 나오면 시작
            if(to == -1 && map[x][y] > 1) {
                weight = 0;
                // 섬 번호를 2부터 시작 했었기 때문에 인덱스 조회를 위해 -2 해준다
                from = map[x][y] - 2; // 시작한 섬의 번호 
            }
            
            if(isVertical)
                y += dy[3];
            else
                x += dx[1];
            
            if(x >= N || y >= M) break;
            
            // 바다 일 때 다리 길이 ++
            if(from > -1 && map[x][y] == 0) {
                weight++;
            }

            // 길이 2이상, 시작한 섬과 다른 섬과 만나면 다리 짓기 성공
            else if(weight >= 2 && from + 2 != map[x][y] && map[x][y] > 1) {
                to = map[x][y] - 2;
                
                if(from > -1 && to > -1) 
                    saveEdge(from, to, weight);
                
                from = -1;
                to = -1;
            }
        }
    }

    private static void saveEdge(int from, int to, int weight) {
        Edge newEdge = new Edge(from, to, weight);
        // 중복 체크 후 같은 섬을 잇는 다리가 없으면 다리 추가
        if(validate(newEdge)) edgeList.add(newEdge);
    }

    private static boolean validate(Edge newEdge) {
        for(Edge e : edgeList) {
            if(e.from == newEdge.from && e.to == newEdge.to) {
            	if(newEdge.weight < e.weight) return true;
            	return false;
            }
        }
        return true;
    }

    private static int countIsland() {
        // 섬에 번호를 붙이기 위한 변수
        int n = 2;
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                if(map[i][j] != 1) continue;
                bfs(i, j, n);
                n++;
            }
        }
        
        return n;
    }

    private static void bfs(int i, int j, int islandNum) {
        Queue<int[]> q = new ArrayDeque<>();
        map[i][j] = islandNum;
        q.offer(new int[] {i, j});
        
        while(!q.isEmpty()) {
            int[] p = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nx = p[0] + dx[d];
                int ny = p[1] + dy[d];
                
                if(!isIn(nx, ny) || map[nx][ny] == 0 || map[nx][ny] == islandNum) continue;
                map[nx][ny] = islandNum;
                q.offer(new int[] {nx, ny});
            }
        }
    }

    private static boolean isIn(int x, int y) {
        if(-1 < x && x < N && -1 < y && y < M) return true;
        else return false;
    }

    private static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = 0;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
