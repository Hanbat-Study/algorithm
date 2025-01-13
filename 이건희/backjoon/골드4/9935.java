import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s, bombS;
    static int bombLen;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        bombS = br.readLine();
        StringBuilder sb = new StringBuilder();
        bombLen = bombS.length();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (bombLen <= sb.length()) {
                flag = true;

                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bombS.charAt(j)) {
                        flag = false;

                        break;
                    }
                }

                if (flag) sb.delete(sb.length() - bombLen, sb.length());
            }
        }

        if (sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);
    }
}
