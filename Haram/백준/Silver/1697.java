import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer, visited[];
    static int MAX_NUM = 100001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new int[MAX_NUM];
        answer = MAX_NUM;
        
        bfS();
        
        System.out.println(answer);
    }
    
    private static void bfS() {
        Queue<Character> ops = new LinkedList<>();
        Queue<int[]> results = new LinkedList<>();
        
        ops.offer('+');
        ops.offer('-');
        ops.offer('*');
        
        results.offer(new int[] {N, 0});
        results.offer(new int[] {N, 0});
        results.offer(new int[] {N, 0});
        
        while(!ops.isEmpty() || !results.isEmpty()) {
            char op = ops.poll();
            int[] temp = results.poll();
            int n = temp[0];
            int cnt = temp[1];

            if(n < 0 || n >= MAX_NUM) 
                continue;
            
            if(visited[n] > 0 && visited[n] < cnt)
                continue;
            visited[n] = cnt;
            
            if(n == K) {
                answer = visited[n];
                break;
            }
            
            if(op == '+') {
                n += 1;
                
                ops.offer('+');
                results.offer(new int[] {n, cnt+1});

                ops.offer('*');
                results.offer(new int[] {n, cnt+1});
            }
            else if(op == '-') {
                n -= 1;
                
                ops.offer('-');
                results.offer(new int[] {n, cnt+1});
                
                ops.offer('*');
                results.offer(new int[] {n, cnt+1});
            }
            else if(op == '*') {
                n *= 2;
                
                ops.offer('+');
                results.offer(new int[] {n, cnt+1});

                ops.offer('-');
                results.offer(new int[] {n, cnt+1});
                
                ops.offer('*');
                results.offer(new int[] {n, cnt+1});
            }
        }   
    }
}