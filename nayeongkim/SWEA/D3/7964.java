import java.io.BufferedReader;
import java.io.InputStreamReader;

class Soultion{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int D = Integer.parseInt(str[1]);
            int cnt = 0;
            int sum = 0;
            String[] map= br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                if (map[i].equals("0")) {
                    cnt++;
                    if (cnt == D) {
                        sum++;
                        cnt = 0;
                    }
                } else {
                    cnt = 0;
                }
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}