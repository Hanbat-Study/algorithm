import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution_2382 {
    static class Virus implements Comparable<Virus> {
        int r, c, size, dir, num; // num:2차배열을 1차로 생각해서 부여한 칸의번호

        public Virus(int r, int c, int size, int dir) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.dir = dir;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.num == o.num) { // 혹시 칸번호가 같으면 2순위 기준은 군집크기 내림차순
                return o.size - this.size;
            }
            return this.num - o.num; // 일단 칸번호 정렬이 1순위 기준
        }
    }
    static int n, m, k;
    static int[][] map;
    static int[] dr = {0, -1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, 0, -1, 1};
    static int[][] dir;
    static ArrayList<Virus> virusList;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            virusList = new ArrayList<Virus>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                virusList.add(new Virus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            for (int t = 0; t < m; t++) {
                for (int i =0; i <virusList.size(); i++) {
                    Virus v = virusList.get(i);
                    int nr = v.r + dr[v.dir];
                    int nc = v.c + dc[v.dir];
                    v.r = nr;
                    v.c = nc;
                    v.num = v.r * n + v.c;
                    if (v.r == 0 || v.r == n -1 || v.c == 0|| v.c == n-1) {
                        v.size /= 2;
                        v.dir = v.dir % 2 == 0 ? v.dir -1 : v.dir + 1;
                        if (v.size == 0) {
                            virusList.remove(i);
                            i--;
                        }
                    }
                }
                Collections.sort(virusList);
                for (int i = 0; i <virusList.size() - 1; i++) {
                    Virus now = virusList.get(i);
                    Virus next = virusList.get(i + 1);
                    if (now.num == next.num) {
                        now.size += next.size;
                        virusList.remove(i+1);
                        i--;
                    }
                }
            }
            int ans = 0;
            for (Virus v : virusList) {
                ans += v.size;
            }
            System.out.println("#" + tc + " "+ ans);

        }

    }

}
