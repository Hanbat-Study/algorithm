import java.io.*;

class Solution {
	
	static int N, result;
	static int[][] S;
	static boolean[] isSelected;
	static int[] groupA, groupB;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
        	result = -1;
        	N = Integer.parseInt(br.readLine());
        	isSelected = new boolean[N];
        	groupA = new int[N / 2];
        	groupB = new int[N / 2];
        	
        	S = new int[N][N];
        	for(int i = 0; i < N; i++) {
        		String[] str = br.readLine().split(" ");
        		for(int j = 0; j < N; j++)
        			S[i][j] = Integer.parseInt(str[j]);
        	}
        	
        	getComb(0, 0);
        	System.out.println("#" + t + " " + result);
        }
    }
    
    private static void getComb(int cnt, int start) {
    	if(cnt == N / 2) { 
    		getGroups();
    		
    		int sum1 = 0;
        	for(int i = 0; i < N / 2; i++) {
        		for(int j = 0; j < N / 2; j++)
        			sum1 += S[groupA[i]][groupA[j]];
        	}
        	
        	int sum2 = 0;
        	for(int i = 0; i < N / 2; i++) {
        		for(int j = 0; j < N / 2; j++)
        			sum2 += S[groupB[i]][groupB[j]];
        	}

        	if(result == -1)
        		result = Math.abs(sum1 - sum2);
        	else
        		result = Math.min(result, Math.abs(sum1 - sum2));
    		
        	return;
    	}
    	
    	for(int i = start; i < N; i++) {
    		if(isSelected[i]) continue;
    		
    		isSelected[i] = true;
    		getComb(cnt + 1, i + 1);
    		isSelected[i] = false;
    	}
    }
    
    private static void getGroups() {
    	int cntA = 0;
    	int cntB = 0;
    	for(int i = 0; i < N; i++) {
    		if(isSelected[i])
    			groupA[cntA++] = i;
    		else
    			groupB[cntB++] = i;
    	}
    }
}
