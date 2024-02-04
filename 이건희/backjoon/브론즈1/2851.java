import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int result=0;
        for(int i = 0; i < 10; i++) {
            int now = Integer.parseInt(br.readLine());
            if(cnt < 100){
                cnt += now;
                if(Math.abs(result - 100)>Math.abs(cnt - 100)) {
                    result = cnt;
                }else if(Math.abs(result - 100) == Math.abs(cnt - 100)) {
                    result = result > cnt? result : cnt;
                }
            }
        }
        System.out.println(result);
    }
}
