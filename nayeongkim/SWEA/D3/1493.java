import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int MAX = 142;

    public static int[] sumToPoint(int p) {
        int[] arr = new int[2];
        int cnt = 0;
        int x = 1;
        int y = 1;
        for (int i = 0; i < MAX; i++) {
            cnt += i;
            if (cnt >= p) {
                x = i;
                break;
            }

        }
        int minX = cnt - x + 1;
        for (int i = cnt; i >= minX; i--) {
            if (i == p) {
                arr[0] = x;
                arr[1] = y;
                break;
            }
            y++;
            x--;
        }
        return arr;
    }
    public static int pointToSum(int x, int y){
        int sum = 0;
        int line = x + y;
        int diff = line - x -1;
        int max_line = 0;
        for (int i = 1; i < line; i++) {
            max_line += i;
        }
        sum = max_line - diff;
        return sum;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        int[][] intArr = new int[2][2];

        for (int tc = 1; tc <= T; tc++) {
            int x = 1;
            int y = 1;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int cnt = 0;
            intArr[0] = sumToPoint(p);
            intArr[1] = sumToPoint(q);

            x = intArr[0][0] + intArr[1][0];
            y = intArr[0][1] + intArr[1][1];
            cnt = pointToSum(x, y);
            System.out.printf("#%d %d\n",tc,cnt);

        }

    }
}