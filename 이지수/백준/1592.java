import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int L = Integer.parseInt(tmp[2]);
        
        int[] ballCnt = new int[N];
        int max = 0;
        int idx = 0;
        int cnt = -1;
        while(max < M) {
            cnt++;
            ballCnt[idx]++;
            if(max < ballCnt[idx])
                max = ballCnt[idx];
            if((idx == 0 && ballCnt[idx] == 0) || (ballCnt[idx] % 2 == 1))
                idx = (idx + L) % N;
            else {
                if(idx - L >= 0)
                    idx -= L;
                else
                    idx = N - L + idx;
            }
        }
        
        System.out.println(cnt);
    }
}
