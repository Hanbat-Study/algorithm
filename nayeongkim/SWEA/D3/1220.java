import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_1220{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[][] str = new String[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                str[i] = br.readLine().split(" ");
            }
            for (int j= 0; j < N; j++) {
                boolean flag = false;
                for (int i = 0; i < N; i++) {

                    if (str[i][j].equals("1")){
                       flag = true;
                    }
                    else if (flag && str[i][j].equals("2")){
                        flag = false;
                        cnt ++;
                    }


                }

            }
            System.out.printf("#%d %d\n",tc,cnt );

        }
    }
}