import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> times = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            times.add(new int[]{start,end});
        }

        Collections.sort(times,(a,b) -> timesSort(a,b));

        int end=0;
        int ans=0;
        for(int[] time:times){
            if(end<=time[0]){
                end=time[1];
                ans++;
            }
        }
        
        System.out.println(ans);
    }

    static int timesSort(int[] a, int[] b){
        if(a[1]==b[1]){
            return a[0]-b[0];
        }
        return a[1]-b[1];
    }
}
