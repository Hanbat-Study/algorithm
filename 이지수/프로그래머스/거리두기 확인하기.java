import java.util.*;

class Solution {   
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static List<Point> pList = new ArrayList<>();
    static String[] room;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
            pList.clear();
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(places[i][j].charAt(k) == 'P')
                        pList.add(new Point(j, k));
                }
            }
            
            room = places[i];
            boolean flag = true;
            for(int x = 0; x < pList.size(); x++) {
                if(!bfs(pList.get(x))) {
                    answer[i] = 0;
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                answer[i] = 1;
        }
        
        return answer;
    }
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static boolean bfs(Point p) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(p.x);
        q.offer(p.y);
        
        boolean[][] visited = new boolean[5][5];
        visited[p.x][p.y] = true;
        int cnt = 0;
        while(cnt < 3 && !q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i += 2) {
                int x = q.poll();
                int y = q.poll();
                
                if(cnt > 0 && room[x].charAt(y) == 'P') return false;
                
                for(int k = 0; k < 4; k++) {
                    int idxX = x + dx[k];
                    int idxY = y + dy[k];
                    
                    if(idxX < 0 || idxX > 4 || idxY < 0 || idxY > 4 || visited[idxX][idxY]) continue;
                    if(room[idxX].charAt(idxY) == 'X') continue;
                    
                    q.offer(idxX);
                    q.offer(idxY);
                    visited[idxX][idxY] = true;
                }
            }
            
            cnt++;
        }
        
        return true;
    }
}
