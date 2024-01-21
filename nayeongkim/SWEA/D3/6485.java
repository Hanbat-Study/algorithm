import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            int[] B = new int[N];
            int[] sum = new int[5001];
            for (int i = 0; i < N; i++) {
                String[] strings = br.readLine().split(" ");
                A[i] = Integer.parseInt(strings[0]);
                B[i] = Integer.parseInt(strings[1]);
                for(int j = A[i]; j<=B[i]; j++){
                    sum[j]++;
                }
            }
            int P = Integer.parseInt(br.readLine());
            int[] C = new int[P];

            for (int i = 0; i < P; i++) {
                C[i] = Integer.parseInt(br.readLine());
            }
            System.out.printf("#%d ",tc);
            for (int i = 0; i < P; i++) {
                System.out.printf("%d ",sum[C[i]]);
            }
            System.out.println();
        }
    }
}