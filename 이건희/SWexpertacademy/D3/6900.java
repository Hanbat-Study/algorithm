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
 
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String arr[][] = new String[N][2];
            int result = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
 
                arr[i] = new String[]{a, b};
            }
 
            for (int i = 0; i < M; i++) {
                String n = br.readLine();
 
                for (int j = 0; j < N; j++) {
                    String now = arr[j][0];
                    boolean check = false;
 
                    for (int k = 0; k < n.length(); k++) {
                        if (now.charAt(k) != '*' && n.charAt(k) != now.charAt(k)) {
                            check = true;
                            break;
                        }
                    }
 
                    if (!check) result += Integer.parseInt(arr[j][1]);
                }
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
