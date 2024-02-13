import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int[][] map;
	static ArrayList<int[]> chicken = new ArrayList<int[]>();
	static ArrayList<int[]> house = new ArrayList<int[]>();
	static int M, result;
	static boolean[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        
        map = new int[N + 2][N + 2];
        for(int i = 1; i <= N; i++) {
        	tmp = br.readLine().split(" ");
        	for(int j = 1; j <= N; j++) {
        		map[i][j] = Integer.parseInt(tmp[j - 1]);
        		if(map[i][j] == 2)
        			chicken.add(new int[] {i, j});
        		if(map[i][j] == 1)
        			house.add(new int[] {i, j});        		
        	}
        }
        
        selected = new boolean[chicken.size()];
        result = Integer.MAX_VALUE;
        
        getComb(0, 0);
        
        System.out.println(result);
    }
    
    static private void getComb(int cnt, int idx) {
    	if(cnt == chicken.size() - M) {
    		calculate();
    		return;
    	}
    	
    	for(int i = idx; i < chicken.size(); i++) {
    		if(selected[i]) continue;
    		
    		selected[i] = true;
    		getComb(cnt + 1, i + 1);
    		selected[i] = false;
    	}
    }
    
    static private void calculate() {
    	int sum = 0;
    	
    	for(int j = 0; j < house.size(); j++) {
    		int min = Integer.MAX_VALUE;
    		for(int i = 0; i < selected.length; i++) {
        		if(!selected[i]) {
        			int d = Math.abs(house.get(j)[0] - chicken.get(i)[0]) + Math.abs(house.get(j)[1] - chicken.get(i)[1]);
        			min = Math.min(min, d);
        		}
        	}
    		sum += min;        			
		}
    	
    	result = Math.min(sum, result);
    }
}
