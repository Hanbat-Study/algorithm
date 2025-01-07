import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int G, start, end;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        start = 1;
        end = 2;
        check = false;

        while (end < 100000) {
            int weight = end * end - start * start;

            if (weight == G) {
                System.out.println(end);

                check = true;
            }

            if (weight < G) {
                end++;
            } else {
                start++;
            }
        }

        if (!check) System.out.println(-1);
    }
}
