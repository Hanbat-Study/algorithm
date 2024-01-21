import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution_1289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] strings = br.readLine().split("");
            int cnt = 0;
            boolean flag = false;
            for (int i = 0; i < strings.length; i++) {
                if (!flag &&strings[i].equals("1")) {
                    flag = true;
                    cnt++;
                } else if (flag && strings[i].equals("0")) {
                    flag = false;
                    cnt++;
                }
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}