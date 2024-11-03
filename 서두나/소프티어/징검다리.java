import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] a= new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i][0]=Integer.parseInt(st.nextToken());

            int order=0;
            for(int j=0;j<i;j++){
                if(a[j][0]<a[i][0]){
                    order = Math.max(order, a[j][1]);
                }
            }
            a[i][1]=order+1;
        }

        int ans =0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, a[i][1]);
        }
        System.out.println(ans);
        
    }
}
