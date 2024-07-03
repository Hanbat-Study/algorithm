import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        
        int[] d = new int[n+1];
        
        for(int i=0;i<n+1;i++){
            d[i] = -1;
        }
        
        d[destination]=0;
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=0; i<graph.length;i++){
            graph[i]= new ArrayList<Integer>();
        }
        
        for(int[] road:roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(destination);
        
        while (!q.isEmpty()){
            int cur = q.poll();
            
            for(int next :graph[cur]){
                if(d[next]==-1){
                    d[next]=d[cur]+1;
                    q.offer(next);
                }
            }
        }
        
        answer= new int[sources.length];
        
        for(int i=0;i<sources.length;i++){
            answer[i]=d[sources[i]];
        }
        
        return answer;
    }
}
