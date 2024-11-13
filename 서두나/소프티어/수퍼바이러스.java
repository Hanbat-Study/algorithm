import java.io.*;
import java.util.*;

public class Main {

    static int p;
    static int mod = 1_000_000_007;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        long ans = (rec(n*10)*k)%mod;
        System.out.println(ans);
    }

    static long rec(long n){
        if(n==1){
            return p;
        }

        long re = rec(n/2);

        if(n%2==0){
            return (re*re)% mod;
        }
        else{
            return ((re*re)% mod *p) % mod;
        }
    }
} 
                                       
