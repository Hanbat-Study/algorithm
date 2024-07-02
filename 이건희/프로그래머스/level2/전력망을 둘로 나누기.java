import java.util.*;

class Solution {
    static int result;
    static boolean[] visit;
    static List<List<Integer>> list;
    
    public int solution(int n, int[][] wires) {
        result = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            check(i, n, wires);
        }
        
        return result;
    }
    
    public void check(int now, int n, int[][] wires) {
        list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            if (i == now) continue;
            
            int x = wires[i][0] - 1;
            int y = wires[i][1] - 1;
            
            list.get(x).add(y);
            list.get(y).add(x);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        
        visit = new boolean[n];
        visit[0] = true;
        
        while (!q.isEmpty()) {
            int d = q.poll();
            
            for (int num : list.get(d)) {
                if (!visit[num]) {
                    visit[num] = true;
                    q.offer(num);
                }
            }
        }
        
        int cnt = 0;
        
        for (boolean v : visit) {
            if (v) cnt++;
        }
        
        result = Math.min(result, Math.abs(n - 2 * cnt));
    }
}
