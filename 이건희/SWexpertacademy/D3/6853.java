import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
 
            int N = Integer.parseInt(br.readLine());
 
            int[] result = new int[3];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
 
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
 
                if (x1 < x && x < x2 && y1 < y && y < y2) {
                    result[0]++;
                } else if (x < x1 || x2 < x || y < y1 || y2 < y) {
                    result[2]++;
                } else result[1]++;
            }
 
            System.out.printf("#%d %d %d %d\n", test_case, result[0], result[1], result[2]);
        }
    }
}
