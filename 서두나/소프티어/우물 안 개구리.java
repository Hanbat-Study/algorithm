import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] temp = br.readLine().split(" ");
        
        int[] w = new int[n+1];
        for(int i=0;i<n;i++){
            w[i+1]=Integer.parseInt(temp[i]);
        }

        boolean[] isNotBest = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            if(w[to] <= w[from]){
                isNotBest[to] = true;
            }
            if(w[to] >= w[from]){
                isNotBest[from] = true;
            }
        }

        int cnt=0;
        for(int i=1;i<n+1;i++){
            if(!isNotBest[i]){
                cnt++;
            }    
        }
        
        System.out.println(cnt);
    }
}
