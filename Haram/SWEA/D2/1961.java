import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

	    int T = sc.nextInt();
	
	    for(int t=1; t < T+1; t++) {
	        System.out.println("#" + t);
	        
	        int N = sc.nextInt();
	        
	        int[][] originArr = new int[N][N];
	        int[][] firstArr = new int[N][N];
	        int[][] secondArr = new int[N][N];
	        int[][] thirdArr = new int[N][N];
	        
	        
	        for(int i = 0; i < N; i++) {
	        	for(int j = 0; j < N; j++) {
	        		originArr[i][j] = sc.nextInt();
	        	}
	        }
	        
	        for(int i = 0; i < N; i++) {
	        	for(int j = 0; j < N; j++) {
	        		firstArr[i][j] = originArr[N-j-1][i];
	        		secondArr[i][j] = originArr[N-i-1][N-j-1];
	        		thirdArr[i][j] = originArr[j][N-i-1];
	        	}
	        }

	        for(int i = 0; i < N; i++) {
	        	printRow(N, i, firstArr);
	        	System.out.print(" ");
	        	
	        	printRow(N, i, secondArr);
	        	System.out.print(" ");
	        	
	        	printRow(N, i, thirdArr);
	        	System.out.println("");
	        }
	    } 
	    
	    sc.close();
	}

	private static void printRow(int n,int i, int[][] array) {
		for(int j = 0; j < n; j++) {
    		System.out.print(array[i][j]);
    	}
	}
}