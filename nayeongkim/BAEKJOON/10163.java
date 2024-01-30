import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] isFull = new boolean[1002][10002];
        int[] cnt = new int[N];
        int[] x = new int[N];
        int[] y = new int[N];
        int[] w = new int[N];
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i]= Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i >= 0; i--) {
            int W = w[i];
            int H = h[i];
            int X = x[i];
            int Y = y[i];
            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= H; k++) {
                    if(!isFull[X+j][Y+k]){
                        isFull[X+j][Y+k] = true;
                        cnt[i]++;
                    }
                }
            }
        }
        for(int c : cnt){
            System.out.println(c);
        }
    }
}