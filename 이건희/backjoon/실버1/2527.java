import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String[] s = br.readLine().split(" ");
            int nx = Integer.parseInt(s[0]);
            int ny = Integer.parseInt(s[1]);
            int np = Integer.parseInt(s[2]);
            int nq = Integer.parseInt(s[3]);
            int dx = Integer.parseInt(s[4]);
            int dy = Integer.parseInt(s[5]);
            int dp = Integer.parseInt(s[6]);
            int dq = Integer.parseInt(s[7]);
            char result;

            if (np < dx || nq < dy || dp < nx || dq < ny) {
                result = 'd';
            } else if ((np == dx && dy == nq) || (nx == dp && ny == dq) || (nx == dp && nq == dy) || (np == dx && ny == dq)) {
                result = 'c';
            } else if (np == dx || nq == dy || nx == dp || ny == dq) {
                result = 'b';
            } else result = 'a';

            System.out.println(result);
        }
    }
}
