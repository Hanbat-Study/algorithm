import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        check = new boolean[s.length()];

        cal(0, s.length());
    }

    public static void cal(int start, int end) {
        if (end <= start) return;

        int minIndex = start;

        for (int i = start; i < end; i++) {
            if (!check[i] && s.charAt(i) < s.charAt(minIndex)) {
                minIndex = i;
            }
        }

        check[minIndex] = true;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (check[i]) sb.append(s.charAt(i));
        }

        System.out.println(sb);

        cal(minIndex + 1, end);
        cal(start, minIndex);
    }
}
