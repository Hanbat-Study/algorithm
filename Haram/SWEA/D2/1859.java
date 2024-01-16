import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t=1; t < T+1; t++) {
            long answer = 0;
            
            int N = sc.nextInt();
            int[] salePrices = new int[N];
            
            for(int i = 0; i < N; i++) {
                salePrices[i] = sc.nextInt();
            }
            
            int i = N-1;
            int j = i-1;
            
            while(i > -1 && j > -1) {
            	if(salePrices[i] > salePrices[j]) {
            		answer += salePrices[i] - salePrices[j];
            	} else {
            		i = j;
            	}
            	j--;
            }
            
            System.out.println("#" + t + " " + answer);
        }
    }
}