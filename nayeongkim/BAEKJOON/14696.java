import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        for (int i = 0; i < N; i++) {
            str = null;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int[] A = new int[5];
            for (int j = 0; j < a; j++) {
                int n = Integer.parseInt(st.nextToken());
                A[n]++;
            }
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st1.nextToken());
            int[] B = new int[5];
            for (int j = 0; j < b; j++) {
                int m = Integer.parseInt(st1.nextToken());
                B[m]++;
            }
            for (int k = 4; k > 0; k--) {
                if(A[k] > B[k]){
                    str = "A";
                    break;
                } else if (A[k] < B[k]) {
                    str = "B";
                    break;
                }
            }
            if (str == null) {
                str = "D";
            }
            System.out.println(str);
        }


    }
}