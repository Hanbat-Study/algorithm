import java.util.*;

class Solution {
    
    static int M, N;
    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 0) continue;
                
                int tmp = bfs(i, j, picture);
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmp);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int bfs(int r, int c, int[][] picture) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(r);
        q.offer(c);
        
        int cnt = 0;
        int color = picture[r][c];
        picture[r][c] = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            cnt += (size / 2);
            
            for(int i = 0; i < size; i += 2) {
                r = q.poll();
                c = q.poll();
                
                for(int k = 0; k < 4; k++) {
                    int idxR = r + dx[k];
                    int idxC = c + dy[k];
                    
                    if(idxR < 0 || idxR >= M || idxC < 0 || idxC >= N || picture[idxR][idxC] == 0 || picture[idxR][idxC] != color) continue;
                    
                    picture[idxR][idxC] = 0;
                    q.offer(idxR);
                    q.offer(idxC);
                }
            }
        }
        
        return cnt;
    }
}
