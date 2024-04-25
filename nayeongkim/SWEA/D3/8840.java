import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            Long l = Long.parseLong(br.readLine());
            Long res = ((l/2)*(l/2));
            System.out.println("#" + t + " " + res);
        }
    }
}
