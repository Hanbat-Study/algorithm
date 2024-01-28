import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_8320 {
    public static int measure(int n) {
        int result = 0;
        for(int i = 1; i<=Math.sqrt(n); i++) {
            if(n % i == 0){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += measure(i);
        }
        System.out.println(cnt);
    }
}