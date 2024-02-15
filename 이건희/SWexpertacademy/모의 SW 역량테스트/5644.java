import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Solution {
    static int[][] dis = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static int[][] spots;
    static int M, A, xA, yA, xB, yB;
    static ArrayList<ArrayList<Integer>> chargeA, chargeB;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            int result = 0;
            xA = 1;
            yA = 1;
            xB = 10;
            yB = 10;
             
            int[] arrA = new int[M + 1];
            int[] arrB = new int[M + 1];
            chargeA = new ArrayList<>();
            chargeB = new ArrayList<>();
            spots = new int[A][];
             
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
             
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
             
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int xP = Integer.parseInt(st.nextToken());
                int yP = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                 
                spots[i] = new int[] {xP, yP, C, P};
            }
             
            for (int i = 0; i <= M; i++) {
                xA += dis[arrA[i]][0];
                yA += dis[arrA[i]][1];
                xB += dis[arrB[i]][0];
                yB += dis[arrB[i]][1];
                 
                result += charging();
            }
             
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    private static int charging() {
        int cnt = 0;
         
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int a = chargingA(i);
                int b = chargingB(j);
                 
                if (i != j) {
                    cnt = Math.max(cnt, a + b);
                } else {
                    cnt = Math.max(cnt, Math.max(a, b));
                } 
            }
        }
         
        return cnt;
    }
 
    private static int chargingA(int i) {
        if (Math.abs(xA - spots[i][0]) + Math.abs(yA - spots[i][1]) <= spots[i][2]) {
            return spots[i][3];
        }
        return 0;
    }
 
    private static int chargingB(int i) {
        if (Math.abs(xB - spots[i][0]) + Math.abs(yB - spots[i][1]) <= spots[i][2]) {
            return spots[i][3];
        }
        return 0;
    }
}
