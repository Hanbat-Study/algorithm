import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int x1, y1, x2, y2, result;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            result = cal(x1, y1, x2, y2);
             
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    private static int cal(int nx1, int ny1, int nx2, int ny2) {
        int dx = Math.abs(nx1 - nx2);
        int dy = Math.abs(ny1 - ny2);
        int maxNum = Math.max(dx, dy);
        int minNum = Math.min(dx, dy);
        int cnt = maxNum / 2 * 4;;
         
        if (maxNum % 2 == 0) {          
            if ((maxNum- minNum) % 2 != 0) {
                cnt -= 1;
            }
        } else {
            cnt += 1;
            if ((maxNum- minNum) % 2 == 0) {
                cnt += 1;
            }
        }
         
        return cnt;
    }
}
