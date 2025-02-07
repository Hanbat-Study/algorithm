import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[C];

        if (R == 2) {
            System.out.println(0);

            return;
        }

        for (int i = 0; i < R; i++) {
            String s = br.readLine();

            for (int j = 0; j < C; j++) {
                if (i == 0) arr[j] = String.valueOf(s.charAt(j));
                else arr[j] += s.charAt(j);
            }
        }

        for (int i = 1; i < R - 1; i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j < C; j++) {
                String suffix = arr[j].substring(i);

                if (set.contains(suffix)) {
                    System.out.println(i - 1);

                    return;
                }

                set.add(suffix);
            }
        }

        System.out.println(R - 1);
    }
}
