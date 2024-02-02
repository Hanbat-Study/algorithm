import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, C, answer; 
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        
        visited = new boolean[N];
        answer = 0;
        
        graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        } 
        
        for(int i = 0; i < C; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0])-1;
            int b = Integer.parseInt(temp[1])-1;
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(0, 0);
        
        bw.append(answer-1 + "");
        
        bw.flush();
        bw.close();
    }
    private static void dfs(int i, int cnt) {
        visited[i] = true;
        answer++;
        
        for(int n : graph.get(i)) {
            if(visited[n]) continue;
            dfs(n, cnt+1);        
        }
    }
}
