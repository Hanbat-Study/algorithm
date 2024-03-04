import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static class Point {
        int r, c;
        
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static ArrayList<Point> clouds = new ArrayList<>();
    static int N;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M;
        
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        
        map = new int[N][N];
        
        for(int r = 0; r < N; r++) {
            tmp = br.readLine().split(" ");
            for(int c = 0; c < N; c++)
                map[r][c] = Integer.parseInt(tmp[c]);
        }
        
        clouds.add(new Point(N - 1, 0));
        clouds.add(new Point(N - 1, 1));
        clouds.add(new Point(N - 2, 0));
        clouds.add(new Point(N - 2, 1));
        for(int m = 0; m < M; m++) {
            tmp = br.readLine().split(" ");
            int d, s;
            
            d = Integer.parseInt(tmp[0]) - 1;
            s = Integer.parseInt(tmp[1]);
            
            move(d, s);
            makeCloud();
        }
        
        int result = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++)
                result += map[r][c];
        }

        System.out.println(result);
    }
    
    private static void makeCloud() {
        ArrayList<Point> newClouds = new ArrayList<Point>();
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(map[r][c] >= 2) {
                    boolean flag = false;
                    
                    for(int i = 0; i < clouds.size(); i++) {
                        Point p = clouds.get(i);
                        
                        if(p.r == r && p.c == c) {
                            flag = true;
                            break; 
                        }
                    }
                    
                    if(flag)
                        continue;

                    newClouds.add(new Point(r, c));
                    map[r][c] -= 2;
                }
            }
        }
        
        clouds.clear();
        clouds = newClouds;
    }
    
    private static void move(int dir, int s) {    
        for(int i = 0; i < clouds.size(); i++) {
            Point p = clouds.get(i);
            int r = p.r + dx[dir] * s;
            int c = p.c + dy[dir] * s;

            if(r >= N)
                r %= N;
            else if(r < 0 && r % N == 0)
                r = 0;
            else if(r < 0)
                r = N + r % N;
                
            if(c >= N)
                c %= N;
            else if(c < 0 && c % N == 0)
                c = 0;
            else if(c < 0)
                c = N + c % N;
            
            map[r][c]++;
            p.r = r;
            p.c = c;
        }

        for(int i = 0; i < clouds.size(); i++) {
        	Point p = clouds.get(i);
        	map[p.r][p.c] += bug(p.r, p.c);
        }
    }
    
    private static int bug(int r, int c) {
        int cnt = 0;
        
        for(int i = 0; i < 4; i++) {
            int idx1 = r + dx[i * 2 + 1];
            int idx2 = c + dy[i * 2 + 1];
            
            if(idx1 < 0 || idx1 >= N || idx2 < 0 || idx2 >= N || map[idx1][idx2] == 0) continue;
            
            cnt++;
        }

        return cnt;
    }
}
