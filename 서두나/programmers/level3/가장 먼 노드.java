import java.util.*;

class Solution {
    
    class Node{
        int n;
        int d;
        Node(int n, int d){
            this.n=n;
            this.d=d;
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max=0;
        
        List<Integer>[] graph = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
         }
        
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(1, 0));
        visited[1]=true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int next : graph[cur.n]){
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(new Node(next, cur.d+1));
                    if(max<cur.d+1){
                        max=cur.d+1;
                        answer=1;
                    }
                    else if(max==cur.d+1){
                        answer++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}
