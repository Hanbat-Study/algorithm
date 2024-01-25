import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 1; int cnt =1; int n = 1;
        int N = Integer.parseInt(br.readLine());
        for(int i =2;i<=N;i++) {
            cnt++;
            if(cnt /6 == n) {
                result ++;
                n++;
                cnt = 0;
            }
        }
        if (cnt >1) {
            result ++;
        }
        System.out.println(result);
    }

}
