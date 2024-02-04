import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());
        int[] switches = new int[switchNum];
        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i < switchNum; i++) {
            switches[i] = Integer.parseInt(tmp[i]);
        }
        
        int stuNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < stuNum; i++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[1]);
            if(str[0].equals("1")) {
                for(int j = 0; j < switchNum; j++) {
                    if((j + 1) % N == 0)
                        switches[j] = Math.abs(switches[j] - 1);
                }
            }
            else {
                int cnt = 1;
                switches[N - 1] = Math.abs(switches[N - 1] - 1);
                while(N - 1 - cnt >= 0 && N - 1 + cnt < switchNum) {
                    if(switches[N - 1 - cnt] == switches[N - 1 + cnt]) {
                        switches[N - 1 - cnt] = Math.abs(switches[N - 1 - cnt] - 1);
                        switches[N - 1 + cnt] = Math.abs(switches[N - 1 + cnt] - 1);
                    }
                    else
                        break;
                    cnt++;
                }
            }    
        }
        
        int idx = 0;
        while(idx < switchNum) {
            System.out.printf("%d ", switches[idx]);
            if((idx + 1) % 20 == 0)
                System.out.println();
            idx++;
        }
        
        br.close();
    }
}
