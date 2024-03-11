import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] paper = new int[10][10];
        
        String[] tmp;
        for(int r = 0; r < 10; r++) {
        	tmp = br.readLine().split(" ");
        	for(int c = 0; c < 10; c++)
        		paper[r][c] = Integer.parseInt(tmp[c]);
        }
        
        result = Integer.MAX_VALUE;
        int[] pNums = {5, 5, 5, 5, 5};
        start(paper, pNums, 0, 0, 0);
        
        if(result == Integer.MAX_VALUE)
        	System.out.println(-1);
        else
        	System.out.println(result);
    }
    
    private static void start(int[][] paper, int[] pNums, int x, int y, int cnt) {
    	if(x == 10) {
    		result = Math.min(result, cnt);
    		return;
    	}
    	
    	if(paper[x][y] == 1) {
			for(int idx = 1; idx <= 5; idx++) {
				if(pNums[idx - 1] > 0 && isIn(paper, x, y, idx)) {
					int[][] copy = copy(paper);
					cover(copy, x, y, idx);
					int[] copyPnums = Arrays.copyOf(pNums, 5);
					copyPnums[idx - 1]--;

					if(y + idx > 9)
						start(copy, copyPnums, x + 1, 0, cnt + 1);
					else
						start(copy, copyPnums, x, y + idx, cnt + 1);
				}
			}    			
		}
    	else {	
    		if(y >= 9)
    			start(paper, pNums, x + 1, 0, cnt);
    		else
    			start(paper, pNums, x, y + 1, cnt);    		
    	}
    }
    
    private static void cover(int[][] paper, int r, int c, int size) {
    	for(int i = r; i < r + size; i++) {
    		for(int j = c; j < c + size; j++)
    			paper[i][j] = 0;    			
    	}
    }
    
    private static int[][] copy(int[][] paper) {
    	int[][] copy = new int[10][10];
    	
    	for(int r = 0; r < 10; r++) {
    		for(int c = 0; c < 10; c++)
    			copy[r][c] = paper[r][c];
    	}
    	
    	return copy;
    }
    
    private static boolean isIn(int[][] paper, int r, int c, int size) {
    	for(int i = r; i < r + size; i++) {
    		for(int j = c; j < c + size; j++) {
    			if(i >= 10 || j >= 10 || paper[i][j] == 0)
    				return false;
    		}
    	}
    	
    	return true;
    }
}
