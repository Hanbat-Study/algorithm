package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        StringTokenizer s = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            result[i] = Integer.parseInt(s.nextToken());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = num - 1; j < N; j++) {
                    if ((j + 1) % num == 0) {
                        result[j] = result[j] == 0? 1: 0;
                    }
                }
            } else {
                int left = num - 1;
                int right = num - 1;
                while (0 <= left - 1 && right + 1 < N) {
                    if (result[left - 1] != result[right + 1]) {
                        break;
                    }
                    left--;
                    right++;
                }
                for (int k = left; k <= right; k++) {
                    if (result[k] == 1) {
                        result[k] = 0;
                    } else {
                        result[k] = 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            System.out.print(result[i] + " ");
            if((i+1) % 20 == 0)
                System.out.println();
        }
    }
}
