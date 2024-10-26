import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 2;

        for (int i = 1; i <= N; i++) {
            cnt *= 2;
            cnt--;
        }

        System.out.println((int) Math.pow(cnt, 2));
    }
}
