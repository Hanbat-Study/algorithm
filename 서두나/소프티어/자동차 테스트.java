import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());

        int[] car = new int[n];
        
        for(int i=0;i<n;i++){
            car[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(car);

        for(int i=0;i<q;i++){
            int v = Integer.parseInt(br.readLine());

            int left=0;
            int right=n-1;
            int mid=-1;
            while(left<=right){
                mid=(left+right)/2;
                if(car[mid]==v){
                 break;   
                }
                if(car[mid]>v){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            } 

            int ans=0;
            if(car[mid]!=v || car[0]>=v || car[n-1]<=v){
                ans=0;
            }
            else{
                ans=mid*(n-1-mid);
            }
            System.out.println(ans);
        }
    }
}
