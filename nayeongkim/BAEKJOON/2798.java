import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_2798 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int result = 0;
        int idx  = 0;
        for (int i = 0; i<N-2;i++){
            for (int j = i+1; j <N-1; j++){
                for (int k= j+1; k<N;k++) {
                    if(arr[i] + arr[j] + arr[k] <= M ) {
                        result = Math.max(result, arr[i] + arr[j] + arr[k]);
                    }

                }
            }
        }

        System.out.println(result);
    }

}