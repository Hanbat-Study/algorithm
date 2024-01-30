import java.io.*;
import java.util.*;
class Main_2810 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        int result = 0;
        int cnt = -1;
        strings = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            if (strings[i].equals("L")) {
                cnt++;
                i++;
            }
        }
        if(cnt <0) {
            result = N;
        } else {
            result = N - cnt;
        }
        System.out.println(result);
    }
}