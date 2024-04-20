import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n+1];
        
        for(int i=0;i<money.length;i++){
            dp[money[i]]+=1;
            for(int j=money[i];j<n+1;j++){
                dp[j]+=dp[j-money[i]];
            }
        }
        return dp[n];
    }
}
