import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2606{
    static int N, R, sum;
    static boolean[] isSelected;
    static boolean[][] computer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        isSelected = new boolean[N+1];
        computer = new boolean[N+1][N+1];
        sum = 0;
        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computer[x][y] =computer[y][x] = true;
        }
        virus(1);
        System.out.println(sum);
    }

    private static void virus(int cnt) {
        isSelected[cnt] = true;

        for(int i = 1; i<=N; i++){
            if(computer[cnt][i] && !isSelected[i]) {
                sum++;
                virus(i);
            }
        }
    }
}