import java.util.*;

class Solution {
    static int W, H;
    static boolean[][] visited;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] boards = new char[m][n];
        W = n;
        H = m;
        visited = new boolean[H][W];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                boards[i][j] = board[i].charAt(j);
        }
        
        while(answer <= n * m) {
            int removeCnt = bfs(boards);

            if(removeCnt == 0)
                break;
            
            answer += removeCnt;
        }
        
        return answer;
    }
    
    static List<Integer> remove = new ArrayList<>();
    public int bfs(char[][] boards) {
        remove.clear();
        for(int r = 0; r < H; r++) {
            for(int c = 0; c < W; c++) {
                visited[r][c] = false;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        q.offer(0);
        
        int[] dx = {0, 1, 1};
        int[] dy = {1, 1, 0};
        while(!q.isEmpty()) {
            int size = q.size() / 2;
            
            for(int r = 0; r < size; r++) {
                int currentX = q.poll();
                int currentY = q.poll();
            
                char current = boards[currentX][currentY];
                int cnt = 0;
                for(int k = 0; k < 3; k++) {
                    int row = currentX + dx[k];
                    int col = currentY + dy[k];
                    
                    if(row < H - 1 && col < W - 1 && !visited[row][col]) {
                        q.offer(row);
                        q.offer(col);
                        visited[row][col] = true;
                    }
                    
                    if(boards[row][col] == current)
                        cnt++;
                }
                
                if(current == '0')
                    continue;
                    
                if(cnt == 3) {
                    remove.add(currentX);
                    remove.add(currentY);
                    
                    for(int k = 0; k < 3; k++) {
                        int row = currentX + dx[k];
                        int col = currentY + dy[k];
                        
                        remove.add(row);
                        remove.add(col);
                    }
                }
            }
        }
        
        int result = 0;
        for(int s = 0; s < remove.size(); s += 2) {
            int x = remove.get(s);
            int y = remove.get(s + 1);
            
            if(boards[x][y] != '0') {
                boards[x][y] = '0';
                result++;
            }
        }
        
        move(boards);
        
        return result;
    }
    
    public void move(char[][] boards) {
        for(int c = 0; c < W; c++) {
            for(int r = H - 1; r > 0; r--) {
                if(boards[r][c] == '0') {
                    int next = r - 1;
                    while(next >= 0) {
                        if(boards[next][c] != '0') {
                            boards[r][c] = boards[next][c];
                            boards[next][c] = '0';
                            break;
                        }
                        
                        next--;
                    }
                }
            }
        }
    }
}
