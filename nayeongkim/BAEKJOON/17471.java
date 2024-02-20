import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_17471{
    static int n,res;
    static int[] people;
    static boolean[] isSelected, visited;
    static List<Integer> groupA;
    static List<Integer> groupB;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n + 1];
        isSelected = new boolean[n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }
        graph.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m ; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        res = Integer.MAX_VALUE;
        divide(1);
        res = (res == Integer.MAX_VALUE) ? -1 : res;
        System.out.println(res);
    }

    private static void divide(int idx) {
        if (idx == n +1 ){
            groupA = new ArrayList<>();
            groupB = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (isSelected[i]) groupA.add(i);
                else groupB.add(i);
            }
            if (groupA.isEmpty() || groupB.isEmpty()) return;
            if (check(groupA) && check(groupB)) {
                int sumA = 0;
                int sumB = 0;
                for (int a : groupA) sumA += people[a];
                for (int b : groupB) sumB += people[b];
                res = Math.min(res, Math.abs(sumA - sumB));
            }
            return;
        }
        isSelected[idx] = true;
        divide(idx + 1);
        isSelected[idx] = false;
        divide(idx + 1);
    }

    private static boolean check(List<Integer> group) {
        if (group.isEmpty()) return false;
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n + 1];
        visited[group.get(0)] = true;
        q.offer(group.get(0));
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int e : graph.get(cur)) {
                if (!visited[e] && group.contains(e)) {
                    visited[e] = true;
                    q.offer(e);
                }
            }
        }
        for (int g : group) {
            if (!visited[g]) return false;
        }
        return true;
    }


}