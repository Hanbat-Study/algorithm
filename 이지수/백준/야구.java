import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, result;
	static boolean[] isSelected = new boolean[9];
	static int[] selected = new int[9];
	static int[][] nums;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        nums = new int[N][9];
        String[] tmp;
        
        for(int i = 0; i < N; i++) {
        	tmp = br.readLine().split(" ");
        	for(int j = 0; j < 9; j++)
        		nums[i][j] = Integer.parseInt(tmp[j]);
        }
        
        selected[3] = 0;
        isSelected[3] = true;
        
        getPermu(1);
        
        System.out.println(result);
    }
    
    private static void getPermu(int cnt) {
    	if(cnt == 9) {
    		result = Math.max(result, calculate());
    		return;
    	}
    	
    	for(int i = 0; i < 9; i++) {
    		if(isSelected[i]) continue;
    		
    		isSelected[i] = true;
    		selected[i] = cnt;
    		getPermu(cnt + 1);
    		isSelected[i] = false;
    	}
    }
    
    private static int calculate() {
    	int idx = 0;
    	int score = 0;

    	for(int j = 0; j < N; j++) {
    		int out = 0;
    		int curScore = 0;
    		boolean[] ground = new boolean[3];

    		while(out < 3) {
    			if(nums[j][selected[idx]] == 0)
    				out++;
    			else if(nums[j][selected[idx]] == 1) {
    				if(ground[2]) {
    					curScore++;
    					ground[2] = false;
    				}
    				
    				if(ground[1]) {
    					ground[2] = true;
    					ground[1] = false;
    				}
    				
    				if(ground[0])
    					ground[1] = true;
    				
    				ground[0] = true;
    			}
    			else if(nums[j][selected[idx]] == 2) {
    				if(ground[2]) {
    					curScore++;
    					ground[2] = false;
    				}
    				
    				if(ground[1])
    					curScore++;
    				
    				if(ground[0]) {
    					ground[2] = true;
    					ground[0] = false;
    				}
    				
    				ground[1] = true;
    			}
    			else if(nums[j][selected[idx]] == 3) {
    				if(ground[2])
    					curScore++;
    					
    				if(ground[1]) {
    					curScore++;
    					ground[1] = false;
    				}
    				
    				if(ground[0]) {
    					curScore++;
    					ground[0] = false;
    				}
    				
    				ground[2] = true;
    			}
    			else if(nums[j][selected[idx]] == 4) {
    				if (ground[2]) {
    					curScore++;
                        ground[2] = false;
                    }

                    if (ground[1]) {
                    	curScore++;
                        ground[1] = false;
                    }

                    if (ground[0]) {
                    	curScore++;
                        ground[0] = false;
                    }
                    
    				curScore++;
    			}
    			
    			idx = (idx + 1) % 9;
    		}
    		
    		score += curScore;
    	}


    	return score;
    }
}
