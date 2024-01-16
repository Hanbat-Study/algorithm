import java.util.*;

public class Solution {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

	    int T = sc.nextInt();
	
	    for(int t=1; t < T+1; t++) {
	    	int N = sc.nextInt();
	    	
	        System.out.println("#" + t);
	        
	        int[][] snail = new int[N][N];
	        boolean[][] visited = new boolean[N][N];	        
	        
	        int num = 1;
	        int x = 0;
	        int y = 0;
	        int dir = 0;
	        
	        while(num < N*N+1) {
	        	snail[x][y] = num++;
	        	visited[x][y] = true;
	        	
	        	int dx = x + dX[dir];
	        	int dy = y + dY[dir];
	        	
	        	if(isIn(N, dx, dy) && visited[dx][dy] == false) {
	        		x = dx;
	        		y = dy;
	        	} else {
	        		dir++;
	        		dir %= 4;
	        		x += dX[dir];
	        		y += dY[dir];
	        	}
	        }
	        
	        printSnail(N, snail);
	    } 
	    sc.close();
	}

	private static void printSnail(int n, int[][] snail) {
		for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) { 
        		System.out.print(snail[i][j]);
        		System.out.print(" ");
        	}	        	
        	System.out.println("");
        }
	}

	private static boolean isIn(int n, int x, int y) {
		if(-1 < x && x < n &&  -1 < y && y < n) 
			return true;
		else			
			return false;
	}
}