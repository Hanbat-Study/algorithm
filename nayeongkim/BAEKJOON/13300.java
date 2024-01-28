import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_13300 {
    public static int total(int[] n, int K) {
        int result = 0;
        for (int i = 1; i <= 6; i++) {
            while (n[i] > 0) {
                result++;
                n[i] -= K;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] gradeW = new int[7];
        int[] gradeM = new int[7];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st1.nextToken());
            int Y = Integer.parseInt(st1.nextToken());
            if (S == 1){
                gradeW[Y]++;

            } else {
                gradeM[Y]++;
            }
        }
        cnt = total(gradeM, K) + total(gradeW, K);
        System.out.println(cnt);
    }
}