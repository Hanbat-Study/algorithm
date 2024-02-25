import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_1339 {
    static int n, res;
    static int max = 9;
    static int[] alphabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j <s.length(); j++) {

                    alphabet[((int)s.charAt(j) - 65) ] += (int)Math.pow(10, Math.abs(s.length() - 1 - j));
            }
        }
        Arrays.sort(alphabet);
        for (int i = 25; i >=0; i--) {
            if (alphabet[i] == 0) break;
            res += alphabet[i] * max--;
        }
        System.out.println(res);
    }
}