import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br;
    static int T, M, A, am[], bm[], aps[][], ax, ay, bx, by, charge;
    
    // 이동x, 상, 우, 하, 좌 
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc < T+1; tc++) {            
            input();
            
            ax = 1;
            ay = 1;
            bx = 10;
            by = 10;
            for(int time = 0; time < M+1; time++) {
                int[][] cb = new int[2][A];
                boolean[] isDupl = new boolean[A];
                 
                for(int n = 0; n < A; n++) {
                    // aps[n][0-1]: 좌표, [2]: 충전 가능 거리, [3]: 충전량
                    boolean isA = Math.abs(ax - aps[n][1]) + Math.abs(ay - aps[n][0]) <= aps[n][2];
                    boolean isB = Math.abs(bx - aps[n][1]) + Math.abs(by - aps[n][0]) <= aps[n][2];
                    
                    if(isA && isB) isDupl[n] = true;
                    if(isA) cb[0][n] = aps[n][3];
                    if(isB) cb[1][n] = aps[n][3];
                }
                 
                 int sum = 0;
                 int temp = 0;
                 
                 for(int i = 0; i < A; i++) {
                     for(int j = 0; j < A; j++) {
                         temp = cb[0][i] + cb[1][j];
                         
                         if (i == j && isDupl[i]) {
                             temp /= 2;
                         }
                         
                         sum = Math.max(sum, temp);
                     }
                 }
                 charge += sum;
                 
                move(time);
            }
                   
            
            System.out.println("#" + tc + " " + charge);
        }
    }
    
    private static void move(int t) {
        ax += dx[am[t]];
        ay += dy[am[t]];
        bx += dx[bm[t]];
        by += dy[bm[t]];
    }

    private static void input() throws Exception {
        String[] temp = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]); // 이동 시간 
        A = Integer.parseInt(temp[1]); // BC의 개수
        am = new int[M+1]; // A의 이동 정보
        bm = new int[M+1]; // B의 이동 정보
        aps = new int[A][4]; // AP 정보: x, y, 충전 범위, 처리량
        charge = 0;
        
        temp = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            am[i] = Integer.parseInt(temp[i]); 
        }
        
        temp = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            bm[i] = Integer.parseInt(temp[i]); 
        }
        
        for(int i = 0; i < A; i++) {
            temp = br.readLine().split(" ");            
            for(int j = 0; j < 4; j++) {
                aps[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

}