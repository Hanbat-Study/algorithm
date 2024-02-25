import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int N, M, D, enemyCnt, result;
	static boolean[] archer, disable;
	static int[] enemyPoints;
	static int[] enemyPointsCopy;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        D = Integer.parseInt(tmp[2]);
        archer = new boolean[M];
        enemyCnt = 0;
        int[][] map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	tmp = br.readLine().split(" ");
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(tmp[j]);
        		if(map[i][j] == 1) 
        			enemyCnt++;
        	}
        }
        
        enemyPoints = new int[enemyCnt * 2];
        
        int idx = 0;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(map[i][j] == 1) {
        			enemyPoints[idx++] = i;
        			enemyPoints[idx++] = j;        			
        		}
        	}
        }
        
        setArcher(0, 0);
        
        System.out.println(result);
    }
    
    private static void setArcher(int idx, int cnt) {
    	if(cnt == 3) {
    		result = Math.max(result, playGame());
    		return;
    	}
    	
    	for(int i = idx; i < M; i++) {
    		if(archer[i]) continue;
    		
    		archer[i] = true;
    		setArcher(i + 1, cnt + 1);
    		archer[i] = false;
    	}
    }
    
    private static int playGame() {
    	int cnt = 0;
    	enemyPointsCopy = Arrays.copyOf(enemyPoints, enemyPoints.length);
    	
    	int enemies = enemyCnt;
    	disable = new boolean[enemies];	

    	while(enemies > 0) {
    		//공격
    		ArrayList<Integer> attacked = new ArrayList<Integer>();
    		for(int i = 0; i < M; i++) {
    			if(!archer[i]) continue;

    			int enemyIdx = attack(i);
    			if(enemyIdx != -1)
    				attacked.add(enemyIdx);
    		}
    		
    		for(int i = 0; i < attacked.size(); i++) {
    			if(disable[attacked.get(i)]) continue;
    			
    			disable[attacked.get(i)] = true;
    			cnt++;
    			enemies--;
    		}
    		
    		for(int i = 0; i < enemyCnt; i++) {    			
    			if(disable[i]) continue;
    			
    			int r = enemyPointsCopy[i * 2];
    			
    			if(r == N - 1) {
    				disable[i] = true;
    				enemies--;
    				continue;
    			}
    			
    			enemyPointsCopy[i * 2]++;
    		}
    	}
    	
    	return cnt;
    }
    
    private static int attack(int idx) {
    	int minD = Integer.MAX_VALUE;
    	int enemyIdx = -1;
    	
    	for(int i = 0; i < enemyCnt; i++) {
    		if(disable[i]) continue;
    		
    		int r = enemyPointsCopy[i * 2];
    		int c = enemyPointsCopy[i * 2 + 1];
    		int d = Math.abs(N - r) + Math.abs(idx - c);
    		
    		if(d > D) continue;
    		
    		if((d < minD) || (d == minD && c < enemyPointsCopy[enemyIdx * 2 + 1])){
    			minD = d;
    			enemyIdx = i;
    		}
    	}
    	
    	return enemyIdx;
    }
}
