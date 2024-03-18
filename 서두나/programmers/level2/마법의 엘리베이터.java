import java.util.*;

class Solution {
    static int answer;
    public int solution(int storey) {
        answer = Integer.MAX_VALUE;
        dfs(storey, 0);
        return answer;
    }
    
    public void dfs(int n, int cnt){
        if(n<10){
            answer=Math.min(answer, Math.min(cnt + n % 10, cnt + (10 - n % 10) + 1));
            return;
        }
        dfs(n / 10, cnt + n % 10);
        dfs(n / 10 + 1, cnt + (10 - n % 10));
    }
}
