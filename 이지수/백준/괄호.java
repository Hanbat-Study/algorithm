import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int N;
    static long result;
    static String exp;
    static boolean[] selected;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = Integer.MIN_VALUE;
        exp = br.readLine().trim();
        selected = new boolean[N / 2];
        
        for(int i = 0; i <= (N - 2) / 3; i++)
        	setP(0, 0, 0, i, new StringBuilder(exp));
        
        System.out.println(result);
    }
    
    private static void setP(int idx, int cnt, int pIdx, int pNum, StringBuilder sb) {
    	if(cnt == pNum) {
    		result = Math.max(result, calculate(sb.toString()));
    		return;
    	}
        for(int i = idx; i < sb.length() - 2; i += 2) {
            if(selected[pIdx]) continue;
            
            selected[pIdx] = true;
            StringBuilder next = new StringBuilder(sb);
            next.insert(i, '(');
            next.insert(i + 4, ')');
            setP(i + 6, cnt + 1, pIdx + 1, pNum, next);
            selected[pIdx] = false;
        }
    }
    
    private static long calculate(String exp) {
        Queue<String> q = new ArrayDeque<>();
        long result = 0;
        
        int idx = 0;
        int pResult = 0;
        while(idx < exp.length()) {
            char c = exp.charAt(idx);
            
            if(c == '(') {
                pResult = exp.charAt(++idx) - '0';
                char op = exp.charAt(++idx);
                int n = exp.charAt(++idx);
                
                if(op == '+')
                    pResult += (n - '0');
                else if(op == '*')
                    pResult *= (n - '0');
                else
                    pResult -= (n - '0');
                
                q.offer(pResult + "");
                idx += 2;
                continue;
            }
            q.offer(c + "");

            idx++;
        }
        
        result += Integer.parseInt(q.poll());
        
        while(!q.isEmpty()) {
            String op = q.poll();
            int n = Integer.parseInt(q.poll());
            
            if(op.equals("+"))
            	result += n;
            else if(op.equals("*"))
            	result *= n;
            else 
            	result -= n;
        }
        
        return result;
    }
}
