import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2961 {
    static int N, minDiif;
    static int S[], B[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];
        minDiif = 1000000000;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        food(0,0,1,false);
        System.out.println(minDiif);
    }
    private static void food(int cnt, int sum, int mul, boolean isChoosen) {
        if(cnt == N){
            if(isChoosen) {
                minDiif = Math.min(minDiif, Math.abs(mul- sum));

            }
            return;
        }
        food(cnt+1, sum +B[cnt], mul*S[cnt], true);
        food(cnt+1, sum, mul, isChoosen);
    }
}