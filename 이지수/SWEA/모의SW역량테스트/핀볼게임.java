import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    static class Point {
        int r, c;
        
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static ArrayList<ArrayList<Point>> wormholes;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new int[N][N];
            wormholes = new ArrayList<>();            
            
            for(int i = 0; i < 5; i++)
                wormholes.add(new ArrayList<Point>());
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j] >= 6)
                        wormholes.get(map[i][j] - 6).add(new Point(i, j));
                }
            }
            
            int result = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 0) {
                        result = Math.max(result, startGame(i, j, 0));
                        result = Math.max(result, startGame(i, j, 1));
                        result = Math.max(result, startGame(i, j, 2));
                        result = Math.max(result, startGame(i, j, 3));
                    }
                } 
            }
            
            System.out.println("#" + t + " " + result);
        }
    }

    private static int startGame(int r, int c, int dir) {
        int score = 0;
        
        int idxR = r;
        int idxC = c;
        while(true) {
            if(idxR + dx[dir] < 0 || idxR + dx[dir] >= N || idxC + dy[dir] < 0 || idxC + dy[dir] >= N) {
                dir = (dir + 2) % 4;
                score++;
            }
            else {
                idxR += dx[dir];
                idxC += dy[dir];                
            }

            if(map[idxR][idxC] == -1 || (idxR == r && idxC == c))
                break;
            
            if(map[idxR][idxC] > 0 && map[idxR][idxC] <= 5) {
                dir = meetBlock(map[idxR][idxC], dir);
                score++;
            }
            else if(map[idxR][idxC] > 5) {
                Point p = meetWormhole(idxR, idxC, map[idxR][idxC]);
                idxR = p.r;
                idxC = p.c;
            }
        }
        
        return score;
    }
    
    private static Point meetWormhole(int r, int c, int whNo) {
        int whIdx = whNo - 6;
        
        for(int i = 0; i < wormholes.get(whIdx).size(); i++) {
            Point p = wormholes.get(whIdx).get(i);
            
            if(p.r != r || p.c != c)
                return p;
        }
        
        return null;
    }

    private static int meetBlock(int blockNo, int dir) {
        if(blockNo == 1) {
            if(dir == 0 || dir == 1) return dir + 2;
            
            if(dir == 2) return 1;
            
            return 0;
        }
        else if(blockNo == 2) {
            if(dir == 1 || dir == 2) return (dir + 2) % 4;
            
            if(dir == 0) return 1;
            
            return 2;
        }
        else if(blockNo == 3) {
            if(dir == 2 || dir == 3) return (dir + 2) % 4;
            
            if(dir == 0) return 3;
            
            return 2;
        }
        else if(blockNo == 4) {
            if(dir == 3 || dir == 0) return (dir + 2) % 4;
            
            if(dir == 1) return 0;
            
            return 3;
        }
        
        return (dir + 2) % 4;
    }
}
