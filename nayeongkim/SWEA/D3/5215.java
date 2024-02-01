import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_5215{
    static int N, L, sum, t[], k[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            sum = 0;
            t = new int[N];
            k = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken());
                k[i] = Integer.parseInt(st.nextToken());

            }
            hamburger(0,0, 0);
            System.out.println("#"+tc+" "+sum);
        }


    }
    private static void hamburger(int cnt, int taste, int kcal){
        if(kcal>L) return;
        if(sum <taste) sum = taste;
        if(cnt ==N) return;

        hamburger(cnt+1, taste+t[cnt], kcal+k[cnt]);
        hamburger(cnt+1, taste, kcal);
    }
}