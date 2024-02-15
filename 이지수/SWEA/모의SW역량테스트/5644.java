import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	
	static int M;
	static ArrayList<int[]> BC;
	static ArrayList<ArrayList<Integer>> aBCInfo;
	static ArrayList<ArrayList<Integer>> bBCInfo;
	static String[] AMoves;
	static String[] BMoves;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
        	String[] tmp = br.readLine().split(" ");
        	M = Integer.parseInt(tmp[0]);
        	int A = Integer.parseInt(tmp[1]);
        	BC = new ArrayList<int[]>();
        	
        	AMoves = br.readLine().split(" ");
        	BMoves = br.readLine().split(" ");
        	
        	for(int i = 0; i < A; i++) {
        		tmp = br.readLine().split(" ");

        		int row = Integer.parseInt(tmp[1]) - 1;
        		int col = Integer.parseInt(tmp[0]) - 1;
        		
        		BC.add(new int[] {row, col, Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3])});        		
        	}
        	
        	chargeInfo();
        	System.out.println("#" + t + " " + calculateP());
        }
    }
    
    private static int calculateP() {
    	int result = 0;
    	
    	for(int i = 0; i < M + 1; i++) {
    		int aBCInfoSize = aBCInfo.get(i).size();
    		int bBCInfoSize = bBCInfo.get(i).size();

    		if(aBCInfoSize == 0 && bBCInfoSize == 0) continue;
    		
    		if(aBCInfoSize == 0) {
    			int max = 0;
    			for(int k = 0; k < bBCInfo.get(i).size(); k++) {
    				max = Math.max(max, BC.get(bBCInfo.get(i).get(k))[3]);
    			}
    			result += max;
    			continue;
    		}
    		
    		if(bBCInfoSize == 0) {
    			int max = 0;
    			for(int k = 0; k < aBCInfo.get(i).size(); k++) {
    				max = Math.max(max, BC.get(aBCInfo.get(i).get(k))[3]);
    			}
    			result += max;
    			continue;
    		}
    		
    		if(aBCInfoSize == 1 && bBCInfoSize == 1) {
    			if(aBCInfo.get(i).get(0) == bBCInfo.get(i).get(0))
    				result += BC.get(aBCInfo.get(i).get(0))[3];
    			else {
    				result += BC.get(aBCInfo.get(i).get(0))[3];
    				result += BC.get(bBCInfo.get(i).get(0))[3];
    			}
    			continue;
    		}
    		
    		if(aBCInfoSize == 1) {
    			int aBCIdx = aBCInfo.get(i).get(0);
    			int[] maxIdx = {-1, -1};
    			int bBCIdx = -1;
    			
    			for(int k = 0; k < bBCInfo.get(i).size(); k++) {
    				bBCIdx = bBCInfo.get(i).get(k);
    				if(maxIdx[0] < 0)
    					maxIdx[0] = bBCIdx;
    				else if(BC.get(bBCIdx)[3] > BC.get(maxIdx[0])[3]) {
    					int tmp = maxIdx[0];
    					maxIdx[0] = bBCIdx;
    					maxIdx[1] = tmp;
    				}
    				else if(maxIdx[1] < 0)
    					maxIdx[1] = bBCIdx;
    				else if(BC.get(bBCIdx)[3] > BC.get(maxIdx[1])[3])
    					maxIdx[1] = bBCIdx;
    			}
    			
    			result += BC.get(aBCIdx)[3];
    			
    			if(aBCIdx == maxIdx[0] && maxIdx[1] >= 0)
    				result += BC.get(maxIdx[1])[3];
    			else if(aBCIdx != maxIdx[0])
    				result += BC.get(maxIdx[0])[3];

    			continue;
    		}
    		
    		if(bBCInfoSize == 1) {
    			int bBCIdx = bBCInfo.get(i).get(0);
    			int[] maxIdx = {-1, -1};
    			int aBCIdx = -1;
    			
    			for(int k = 0; k < aBCInfo.get(i).size(); k++) {
    				aBCIdx = aBCInfo.get(i).get(k);
    				if(maxIdx[0] < 0)
    					maxIdx[0] = aBCIdx;
    				else if(BC.get(aBCIdx)[3] > BC.get(maxIdx[0])[3]) {
    					int tmp = maxIdx[0];
    					maxIdx[0] = aBCIdx;
    					maxIdx[1] = tmp;
    				}
    				else if(maxIdx[1] < 0)
    					maxIdx[1] = aBCIdx;
    				else if(BC.get(aBCIdx)[3] > BC.get(maxIdx[1])[3])
    					maxIdx[1] = aBCIdx;
    			}
    			
    			result += BC.get(bBCIdx)[3];
    			
    			if(bBCIdx == maxIdx[0] && maxIdx[1] >= 0)
    				result += BC.get(maxIdx[1])[3];
    			else if(bBCIdx != maxIdx[0])
    				result += BC.get(maxIdx[0])[3];

    			continue;
    		}
    		
			int[] aMaxIdx = {-1, -1};
			int[] bMaxIdx = {-1, -1};
			
			for(int k = 0; k < aBCInfoSize; k++) {
				int aBCIdx = aBCInfo.get(i).get(k);
				if(aMaxIdx[0] < 0)
					aMaxIdx[0] = aBCIdx;
				else if(aMaxIdx[1] < 0) {
					if(BC.get(aBCIdx)[3] > BC.get(aMaxIdx[0])[3]) {
						aMaxIdx[1] = aMaxIdx[0];
						aMaxIdx[0] = aBCIdx;						
					}
					else
						aMaxIdx[1] = aBCIdx;
				}
				else {
					if(BC.get(aBCIdx)[3] > BC.get(aMaxIdx[0])[3]) {
						aMaxIdx[1] = aMaxIdx[0];
						aMaxIdx[0] = aBCIdx;		
					}
					else if(BC.get(aBCIdx)[3] > BC.get(aMaxIdx[1])[3])
						aMaxIdx[1] = aBCIdx;
				}
			}
			
			for(int k = 0; k < bBCInfoSize; k++) {
				int bBCIdx = bBCInfo.get(i).get(k);
				if(bMaxIdx[0] < 0)
					bMaxIdx[0] = bBCIdx;
				else if(bMaxIdx[1] < 0) {
					if(BC.get(bBCIdx)[3] > BC.get(bMaxIdx[0])[3]) {
						bMaxIdx[1] = bMaxIdx[0];
						bMaxIdx[0] = bBCIdx;						
					}
					else
						bMaxIdx[1] = bBCIdx;
				}
				else {
					if(BC.get(bBCIdx)[3] > BC.get(bMaxIdx[0])[3]) {
						bMaxIdx[1] = bMaxIdx[0];
						bMaxIdx[0] = bBCIdx;		
					}
					else if(BC.get(bBCIdx)[3] > BC.get(bMaxIdx[1])[3])
						bMaxIdx[1] = bBCIdx;
				}
			}
			
			if(aMaxIdx[0] == bMaxIdx[0]) {
				result += BC.get(aMaxIdx[0])[3];
				
				if(BC.get(aMaxIdx[1])[3] > BC.get(bMaxIdx[1])[3])
					result += BC.get(aMaxIdx[1])[3];
				else
					result += BC.get(bMaxIdx[1])[3];
			}
			else {
				result += BC.get(aMaxIdx[0])[3];
				result += BC.get(bMaxIdx[0])[3];
			}
    	}
    	
    	return result;
    }
    
    private static void chargeInfo() {
    	int[] a = new int[] {0, 0};
    	int[] b = new int[] {9, 9};
    	
    	aBCInfo = new ArrayList<ArrayList<Integer>>();
    	bBCInfo = new ArrayList<ArrayList<Integer>>();
    	
    	for(int i = 0; i < M + 1; i++) {
    		aBCInfo.add(new ArrayList<Integer>());
    		bBCInfo.add(new ArrayList<Integer>());
    	}
    	
    	for(int i = -1; i < M; i++) {
    		if(i != -1) {
    			a = move(AMoves[i], a);
    			b = move(BMoves[i], b);    			    			
    		}
    		for(int j = 0; j < BC.size(); j++) {
    			if(checkBCRange(j, a))
    				aBCInfo.get(i + 1).add(j);
    			if(checkBCRange(j, b))
   					bBCInfo.get(i + 1).add(j);
    		}
    	}
    }
    
    private static boolean checkBCRange(int idx, int[] pos) {
    	int c = BC.get(idx)[2];
    	int row = BC.get(idx)[0];
    	int col = BC.get(idx)[1];

    	if(Math.abs(pos[0] - row) + Math.abs(pos[1] - col) <= c)
    		return true;
    	
    	return false;
    }
    
    private static int[] move(String dir, int[] pos) {
    	switch(dir) {
    		case "0":
    			return pos;
    		case "1":
    			return new int[] {pos[0] - 1, pos[1]};
    		case "2":
    			return new int[] {pos[0], pos[1] + 1};
    		case "3":
    			return new int[] {pos[0] + 1, pos[1]};
    		case "4":    	
    			return new int[] {pos[0], pos[1] - 1};
    	}
    	
		return null;
    }
}
