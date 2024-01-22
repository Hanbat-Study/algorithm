import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        int result = 0;
        int idx = 0;
        while(num[idx] < M - 1){
            num[idx] += 1;
            if (num[idx] % 2 == 0) {

                idx = (idx + L) % N;

            } else {
                idx = (idx - L + N) % N;
            }
            result++;

        }
        System.out.printf("%d\n", result );
    }
}