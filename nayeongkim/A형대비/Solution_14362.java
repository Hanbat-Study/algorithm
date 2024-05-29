import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_14362 {
    static int[] dr = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int res = 0;
            int x = 0;
            int y = 0;
            int d = 0;
            String s = br.readLine();
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < s.length();i++) {
                    switch (s.charAt(i)) {
                        case 'L':
                            d = (d + 3) % 4;
                            break;
                        case 'R' :
                            d = (d + 1) % 4;
                            break;
                        case 'S' :
                            switch (d) {
                                case 0 : x++; break;
                                case 1 : y--; break;
                                case 2 : x--; break;
                                case 3 : y++; break;

                            }
                            int dist = x * x + y * y;
                            res = Math.max(dist, res);

                    }
                }
                if (x == 0 && y == 0) break;
            }
            if (x != 0 || y != 0) System.out.println("#" + t + " oo");
            else System.out.println("#" + t + " " + res);
        }
    }

}
