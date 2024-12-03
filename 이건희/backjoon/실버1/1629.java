import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Long A, B, C, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        result = 1L;
        A %= C;

        while (true) {
            if (B == 1) break;

            if (B % 2 == 1) {
                result = result * A % C;
                B -= 1;
            }

            A = A * A % C;
            B /= 2;
        }

        result = result * A % C;

        System.out.println(result);
    }
}
