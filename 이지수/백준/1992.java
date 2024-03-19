import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] video;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for(int i = 0; i < N; i++) {
        	String[] tmp = br.readLine().split("");
        	for(int j = 0; j < N; j++)
        		video[i][j] = Integer.parseInt(tmp[j]);
        }
        
        backTracking(0, 0, N);
        
        System.out.println(sb.toString());
    }
    
    private static void backTracking(int r, int c, int n) {
    	int sum = 0;
    	
    	for(int i = r; i < r + n; i++) {
    		for(int j = c; j < c + n; j++) {
    			sum += video[i][j];
    		}
    	}
    	
    	if(sum == 0) {
    		sb.append(0);
    	}
    	else if(sum == n * n) {
    		sb.append(1);
    	}
    	else {
    		int size = n / 2;
    		
    		sb.append("(");
    		backTracking(r, c, size);
    		backTracking(r, c + size, size);
    		backTracking(r + size, c, size);
    		backTracking(r + size, c + size, size);
    		sb.append(")");
    	}
    }
}
