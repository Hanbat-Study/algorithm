import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_6808 {
    static int[] G , I, cards;
    static int N = 18,R = 9;
    static boolean[] isSelected;
    static int win;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            win = 0;
            G = new int[9];
            I = new int[9];
            isSelected = new boolean[9];
            cards = new int[9];

            int idx = 0;
            boolean[] nums = new boolean[19];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < R; i++) {
                G[i] = Integer.parseInt(st.nextToken());
                nums[G[i]] =true;
            }
            for (int i = 1; i <= N; i++) {
                if(nums[i]) continue;
                cards[idx++] = i;
            }
            game(0);
            int lose = 362880-win;
            System.out.println("#"+tc+" "+win+" "+lose);
        }

    }
    private static void game(int cnt){
        if(cnt == R) {
            int gPoint = 0;
            int iPoint = 0;
            for(int i =0; i<R;i++){
                if(G[i] > I[i]) gPoint += G[i] + I[i];
                else iPoint += G[i] + I[i];
            }
            if(gPoint > iPoint) win++;
            return;
        }
        for (int i = 0; i < R; i++) {
            if(isSelected[i]) continue;
            I[cnt] = cards[i];
            isSelected[i] = true;
            game(cnt+1);
            isSelected[i] = false;
        }

    }
}