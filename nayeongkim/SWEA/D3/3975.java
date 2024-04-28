import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution3975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());
            double c = Integer.parseInt(st.nextToken());
            double d = Integer.parseInt(st.nextToken());
            double alice = a / b;
            double bob = c / d;
            String s = null;
            if (alice > bob) s = "ALICE";
            else if (alice < bob) s = "BOB";
            else if (alice == bob) s = "DRAW";
            System.out.println("#" + t+ " " + s);
        }
    }
}