import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int t[], k[];
    static int N, L, sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc =1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            t = new int[N];
            k = new int[N];
            sum = 0;
            for(int i = 0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken()); 
                k[i] = Integer.parseInt(st.nextToken()); 
                         
            }
            hamburger(0, 0, 0);
            System.out.println("#"+tc+" "+sum);
        }
    }
 
    private static void hamburger(int cnt, int taste, int kcal) {
        // TODO Auto-generated method stub
        if(kcal >L) {
            return;
        }
        if(taste > sum) {
            sum = taste;
        }
        if(cnt == N) {
            return;
        }
        hamburger(cnt+1, taste + t[cnt], kcal + k[cnt]);
        hamburger(cnt +1, taste, kcal);
         
    }
 
}
