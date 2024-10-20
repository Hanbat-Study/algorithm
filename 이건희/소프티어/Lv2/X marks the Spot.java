import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split(" ");
            String a = words[0].toUpperCase();
            String b = words[1].toUpperCase();

            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == 'X') sb.append(b.charAt(j));
            }
        }

        System.out.println(sb);
    }
}
