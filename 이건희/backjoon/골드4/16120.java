import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String p, ppap;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        p = br.readLine();
        ppap = "PPAP";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            sb.append(p.charAt(i));

            if (4 <= sb.length()) {
                flag = true;

                for (int j = 0; j < 4; j++) {
                    if (sb.charAt(sb.length() - 4 + j) != ppap.charAt(j)) {
                        flag = false;

                        break;
                    }
                }

                if (flag) sb.delete(sb.length() - 4, sb.length()).append("P");
            }

        }

        if (sb.toString().equals("P")) System.out.println("PPAP");
        else System.out.println("NP");
    }
}
