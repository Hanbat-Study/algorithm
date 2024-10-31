import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int v;
        Node next;
        public Node(int v, Node next) {
            this.v=v;
            this.next=next;
        }
        public Node(int v){
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] graph = new Node[n+1];
        Node[] regraph = new Node[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from] = new Node(to, graph[from]);
            // t,s로 올 수 있는 정점을 구하기 위해 역방향 그래프
            regraph[to] = new Node(from, regraph[to]);
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // s에서 갈 수 있는 정점
        boolean[] visited1 = new boolean[n+1];
        visited1[t]=true;// t에서 갈 수 있는 정점 제외
        dfs(s, visited1, graph);

        // t에서 갈 수 있는 정점
        boolean[] visited2 = new boolean[n+1];
        visited2[s]=true;// s에서 갈 수 있는 정점 제외
        dfs(t, visited2, graph);

        // s에 올 수 있는 정점
        boolean[] visited3 = new boolean[n+1];
        dfs(t, visited3, regraph);

        // t에 올 수 있는 정점
        boolean[] visited4 = new boolean[n+1];
        dfs(s, visited4, regraph);

        int ans=0;
        //visited의 값을 start의 값으로 다르게 줘서, 둘이 합일때 방문한걸로
        for(int i=1;i<n+1;i++){
            if(i==s || i==t){
                continue;
            }
            if(visited1[i] && visited2[i] && visited3[i] && visited4[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int cur, boolean[] visited, Node[] graph){
        if(visited[cur]){
           return; 
        }
        visited[cur]=true;

        for(Node node=graph[cur];node!=null;node=node.next){
            dfs(node.v, visited, graph);
        }
    }
}
