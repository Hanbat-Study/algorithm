import java.io.*;
import java.util.*;
class Main_3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N+1];
        int[] K = new int[N+1];
        boolean[] cake = new boolean[L + 1];
        int[] result = new int[N+1];
        int maxCake = 0;
        int idx = 0;
        int realIdx = 0;
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            K[i] = Integer.parseInt(st.nextToken());
            if(maxCake < K[i] - P[i] + 1) {
                maxCake = K[i] - P[i] + 1;
                idx = i;
            }
            for(int k = P[i]; k<=K[i]; k++) {
                if (!cake[k]) {
                    cake[k] = true;
                    result[i]++;
                }
            }
        }
        maxCake = 0;
        for (int i = 1; i < N+1; i++) {
            if(maxCake < result[i]) {
                maxCake = result[i];
                realIdx = i;
            }
        }
        System.out.println(idx);
        System.out.println(realIdx);
    }
}