import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, result;
	static int[] queens;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queens = new int[N];
        
        backTracking(0);
        
        System.out.println(result);
    }
    
    private static void backTracking(int cnt) {
    	if(cnt == N) {
    		result++;
    		return;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		queens[cnt] = i;
    		if(checkPosition(cnt))
    			backTracking(cnt + 1);
    	}
    }
    
    private static boolean checkPosition(int col) {    	
    	for(int i = 0; i < col; i++) {
    		if(queens[i] == queens[col]) 
    			return false;
    		
    		if(Math.abs(i - col) == Math.abs(queens[i] - queens[col]))
    			return false;
    	}

    	return true;
    }
}
