class Solution {
    static int answer;
    public int solution(int storey) {
        answer = Integer.MAX_VALUE;
        dfs(storey, 0);
        return answer;
    }
    
    public void dfs(int num, int cnt) {
        if (cnt >= answer) return;
        if (num == 0) answer = cnt;
        else {
            dfs(num / 10, cnt + num % 10);
            dfs(num / 10 + 1, cnt + 10 - num % 10);
        }
    }
}
