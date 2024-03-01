import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, result;
    static int[] visited;
    static int[][] arr, sortedList;
    static ArrayList<int[]> people, gates;
    static ArrayList<ArrayList<Integer>> num;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            arr = new int[N][N];
            people = new ArrayList<>();
            gates = new ArrayList<>();
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                 
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                     
                    if (1 == arr[i][j]) {
                        people.add(new int[] {i, j});
                    } else if (2 <= arr[i][j]) {
                        gates.add(new int[] {i, j, arr[i][j]});
                    }
                }
            }
 
            visited = new int[people.size()];
            sortedList = new int[gates.size()][];
             
            comb(0);
             
            System.out.printf("#%d %d\n", test_case, result + 1);
        }
    }
 
    private static void comb(int cnt) {
        if (cnt == people.size()) {
            result = Math.min(result, cal());
            return;
        }
 
        for (int i = 0; i < gates.size(); i++) {
            visited[cnt] = i;
            comb(cnt + 1);
        }
    }
 
    private static int cal() {
        num = new ArrayList<>();
        for (int i = 0; i < gates.size(); i++) {
            num.add(new ArrayList<>());
        }
         
        for (int i = 0; i < people.size(); i++) {
            int[] person = people.get(i);
            int[] gate = gates.get(visited[i]);
             
            num.get(visited[i]).add(Math.abs(person[0] - gate[0]) + Math.abs(person[1] - gate[1]));
        }
         
        return go();
    }
 
    private static int go() {
        int cnt = 0;
 
        sorting();
         
        for (int i = 0; i < sortedList.length; i++) {
            int[] sl = sortedList[i];
             
            if (sl.length == 0) continue;
             
            int c = 0;
            int t = gates.get(i)[2];
             
            if (3 < sl.length) {
                for (int j = 3; j < sl.length; j++) {
                    if (sl[j] - sl[j - 3] < t) {
                        sl[j] += t - sl[j] + sl[j - 3];
                    }
                }               
            }
             
            c = sl[sortedList[i].length - 1] + t;
            cnt = Math.max(cnt, c);
        }
         
        return cnt;
    }
 
    private static void sorting() {
        sortedList = new int[gates.size()][];
         
        for (int i = 0; i < num.size(); i++) {
            int[] sl = new int[num.get(i).size()];
             
            for (int j = 0; j < num.get(i).size(); j++) {
                sl[j] = num.get(i).get(j);
            }
             
            Arrays.sort(sl);
            sortedList[i] = sl;
        }
    }
}
