import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] colors = new int[N][3];
        int[][] costs = new int[N][3];
        
        String[] tmp;
        for(int n = 0; n < N; n++) {
        	tmp = br.readLine().split(" ");
        	colors[n][0] = Integer.parseInt(tmp[0]);
        	colors[n][1] = Integer.parseInt(tmp[1]);
        	colors[n][2] = Integer.parseInt(tmp[2]);
        }
        
        costs[0][0] = colors[0][0];
        costs[0][1] = colors[0][1];
        costs[0][2] = colors[0][2];
        
        // R : 0, G : 1, B : 2
        for(int n = 1; n < N; n++) {   		
    		costs[n][0] = Math.min(costs[n - 1][1], costs[n - 1][2]) + colors[n][0];
    		costs[n][1] = Math.min(costs[n - 1][0], costs[n - 1][2]) + colors[n][1];
    		costs[n][2] = Math.min(costs[n - 1][0], costs[n - 1][1]) + colors[n][2];
    	}
        
        if(costs[N - 1][0] <= costs[N - 1][1] && costs[N - 1][0] <= costs[N - 1][2])
        	System.out.println(costs[N - 1][0]);
        else if(costs[N - 1][1] <= costs[N - 1][2] && costs[N - 1][1] <= costs[N - 1][0])
        	System.out.println(costs[N - 1][1]);
        else
        	System.out.println(costs[N - 1][2]);
        	
    }
}
