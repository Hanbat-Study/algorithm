import java.awt.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] answer = {};
        
        int N = park.length;
        int M = park[0].split("").length;
        String[][] map = new String[N][M];
        
        Point start = new Point();
        
        for(int i = 0; i < N; i++) {
            String[] temp = park[i].split("");
            for(int j = 0; j < temp.length; j++) {
                if(temp[j].equals("S")) start = new Point(i, j);
                
                map[i][j] = temp[j];
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] str = routes[i].split(" ");
            String d = str[0];
            int move = Integer.parseInt(str[1]);
            int dir = 0;
            if(d.equals("N")) dir = 0; 
            if(d.equals("S")) dir = 1; 
            if(d.equals("W")) dir = 2;
            if(d.equals("E")) dir = 3;
            
            int originX = start.x;
            int originY = start.y;
            int nx = start.x;
            int ny = start.y;
            for(int m = 1; m < move+1; m++) {
                nx += dx[dir];
                ny += dy[dir];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny].equals("O"))
                    start.move(nx, ny);
                else {
                    nx -= dx[dir];
                    ny -= dy[dir];
                    start.move(originX, originY);
                    break;
                }
            }
        }
        
        return new int[] {start.x, start.y};
    }
}
