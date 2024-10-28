import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean check = false;

        String[] secretButton = br.readLine().split(" ");
        String[] userButton = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            if (userButton[i].equals(secretButton[0])) {
                for (int j = 0; j < M; j++) {
                    if (N <= i + j || !userButton[i + j].equals(secretButton[j])) {
                        break;
                    }
                    cnt++;
                }
            }

            if (cnt == M) check = true;
            cnt = 0;
        }

        if (check) System.out.println("secret");
        else System.out.println("normal");
    }
}
