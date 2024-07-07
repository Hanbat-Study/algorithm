import java.util.*;

class Solution {
    static int h, w;
    static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static ArrayList<Integer> result;
    
    
    public int[] solution(String[] maps) {
        h = maps.length;
        w = maps[0].length();
        visited = new boolean[h][w];
        result = new ArrayList<>();
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) result.add(bfs(i, j, maps));
            }
        }
        
        if (!result.isEmpty()) {
            int[] nums = new int[result.size()];
            
            for (int i = 0; i < result.size(); i++) nums[i] = result.get(i);
            Arrays.sort(nums);
            return nums;
        } else return new int[] {-1};
    }
    
    private static int bfs(int y, int x, String[] m) {
        int cnt = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        
        cnt += m[y].charAt(x) - '0';
        visited[y][x] = true;
        queue.offer(new int[] {y, x});
        
        while (!queue.isEmpty()) {
            int[] d = queue.poll();
            
            int ny = d[0];
            int nx = d[1];
            
            for (int i = 0; i < 4; i++) {
                int dy = ny + dis[i][0];
                int dx = nx + dis[i][1];
                
                if (0 <= dy && dy < h && 0 <= dx && dx < w && m[dy].charAt(dx) != 'X' && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    cnt += m[dy].charAt(dx) - '0';
                    queue.offer(new int[] {dy, dx});
                }
            }
        }
        
        return cnt;
    }
}
