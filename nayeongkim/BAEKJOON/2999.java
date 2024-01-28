import java.io.*;
import java.util.*;
class Main_2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("");
        int R = 0; int C = 0;
        for (int i = 1; i <= Math.sqrt(strings.length); i++) {
            if(strings.length % i  ==0) {
                R = i;
            }
        }
        C = strings.length / R;
        StringBuilder sb = new StringBuilder();
        String[][] result = new String[C][R];
        int idx = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {

                result[i][j] = strings[idx++];
            }
        }

        for (int j = 0; j < R; j++) {
            for (int i = 0; i < C; i++) {
                sb.append(result[i][j]);

            }
        }
        System.out.println(sb);
    }
}