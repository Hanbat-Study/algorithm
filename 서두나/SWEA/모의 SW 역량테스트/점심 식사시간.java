import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
 
    static class Node {
        int r, c;
 
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
 
    static int n;
//  static Info[][] info = new Info[2][10];
    static int[] a = new int[10];
    static int[] b = new int[10];
    static int cnt;
    static int ans;
 
    static boolean[] check = new boolean[10];
    static List<Integer> time;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            cnt = 0;
            ans = Integer.MAX_VALUE;
 
            n = Integer.parseInt(br.readLine());
 
            List<Node> stair = new ArrayList<>();
            time = new ArrayList<>();
 
            List<Node> person = new ArrayList<>();
 
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int k = Integer.parseInt(st.nextToken());
 
                    if (k == 1) {
                        person.add(new Node(i, j));
                    } else if (k > 1) {
                        stair.add(new Node(i, j));
                        time.add(k);
                    }
                }
            }
 
            for (int i = 0; i < person.size(); i++) {
                int d1 = Math.abs(stair.get(0).r - person.get(i).r) + Math.abs(stair.get(0).c - person.get(i).c);
                int d2 = Math.abs(stair.get(1).r - person.get(i).r) + Math.abs(stair.get(1).c - person.get(i).c);
 
                a[cnt] = d1;
                b[cnt++] = d2;
            }
 
            // 각 입구에서 사람 선택 후 정렬
            recursive(0);
 
            System.out.println("#"+test_case+" "+ans);
        }
    }
 
    static void recursive(int depth) {
        if (depth == cnt) {
            ans = Math.min(ans, getTime());
            return;
        }
 
        check[depth] = true;
        recursive(depth + 1);
        check[depth] = false;
        recursive(depth + 1);
    }
 
    static List<Integer> aTime = new ArrayList<>();
    static List<Integer> bTime = new ArrayList<>();
 
    private static int getTime() {
 
        aTime.clear();
        bTime.clear();
 
        for (int i = 0; i < cnt; i++) {
            if (check[i]) {
                aTime.add(a[i]);
            } else {
                bTime.add(b[i]);
            }
        }
 
        Collections.sort(aTime);
        Collections.sort(bTime);
 
        int[] at = new int[aTime.size()];
        int[] bt = new int[bTime.size()];
 
        for (int i = 0; i < aTime.size(); i++) {
            if (i >= 3 && at[i - 3] > aTime.get(i)) {
                at[i] = at[i - 3] + time.get(0);
            } else {
                at[i] = aTime.get(i) + time.get(0);
            }
        }
 
//      System.out.println("aTime: " + aTime.toString());
 
        for (int i = 0; i < bTime.size(); i++) {
            if (i >= 3 && bt[i - 3] > bTime.get(i)) {
                bt[i] = bt[i - 3] + time.get(1);
            } else {
                bt[i] = bTime.get(i) + time.get(1);
            }
        }
 
//      System.out.println("at: " + Arrays.toString(at));
//      System.out.println("bt: " + Arrays.toString(bt));
 
        if (aTime.size() == 0) {
            return bt[bTime.size() - 1] + 1;
        }
        if (bTime.size() == 0) {
            return at[aTime.size() - 1] + 1;
        }
 
        return Math.max(at[aTime.size() - 1], bt[bTime.size() - 1]) + 1;
    }
}
