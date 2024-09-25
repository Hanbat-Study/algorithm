import java.util.*;

class Solution {
    static boolean[] visited;
    static Queue<String> pq = new PriorityQueue<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(tickets, "ICN", 0, "ICN");
        
        return pq.peek().split(",");
    }
    
    public void dfs(String[][] tickets, String now, int cnt, String path) {
        if (cnt == tickets.length) {
            pq.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt + 1, path + "," + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
