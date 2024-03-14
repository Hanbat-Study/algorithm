class Solution {
    static int result;
    static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(int[][] maps) {
        result = 0;
        
        bfs(0, 0, 0, maps);
        
        return result;
    }
    
    private void bfs(int y, int x, int cnt, int[][] arr) {
        if (y == 5 && x == 5) {
            result = cnt;
            return;
        }
        
        
        for (int i = 0; i < 4; i++) {
            int dy = y + dis[i][0];
            int dx = x + dis[i][1];
            
            if (0 <= dy && dy < 5 && 0 <= dx && dx < 5 && arr[dy][dx] == 1) {
                bfs(dy, dx, cnt + 1, arr);
            }   
        }
    }
}
