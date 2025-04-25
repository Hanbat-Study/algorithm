import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    static int T;
    static Pattern pattern = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String s = br.readLine();

            if (pattern.matcher(s).matches()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
