import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static class Node {
        int r, c; // 위치
        int d; // 방향
        int m; // 시간
        // Node next; // 다음 노드
 
        Node() {
 
        }
 
        void set(int r, int c, int d, int m) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.m = m;
        }
    }
 
    static Node[] bio = new Node[1001]; // 미생물 정보 저장
 
    static long[] cnt = new long[1001];
    static int[] drs = { 0, -1, 1, 0, 0 }; // 상하좌우
    static int[] dcs = { 0, 0, 0, -1, 1 }; // 상하좌우
    static int N, M, K; // 셀의 개수, 격리 시간, 미생물 군집의 개수
    static int[][][] map = new int[2][101][101]; // 각 미생물 군집 번호, 버전, 개수
 
    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < 1001; i++) {
            bio[i] = new Node();
        }
 
        StringBuffer sb = new StringBuffer();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken()); // 셀의 개수
            M = Integer.parseInt(st.nextToken()); // 격리 시간
            K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
 
            // 초기화
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < K; j++) {
                    map[0][i][j] = -1;
                    map[1][i][j] = -1;
                }
            }
 
            // 미생물 군집의 정보: 세로 위치, 가로 위치, 미생물 수, 이동방향
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                cnt[i] = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
 
                bio[i].set(r, c, d, 0);
 
//              if (i > 0) {
//                  bio[i - 1].next = bio[i];
//              }
            }
 
            //
             
            find();
 
            long ans = 0;
 
            for (int i = 0; i < K; i++) {
                ans += cnt[i];
            }
 
            // 0 ~ k : 미생물 군집
 
            System.out.println("#" + test_case + " " + ans);
        }
 
    }
 
    // 이동
    static void find() {
 
        for (int i = 0; i < M; i++) {
 
            for (int id = 0; id < K; id++) {
                Node cur = bio[id];
 
                // 0이면 지울거야,
                if (cnt[id] == 0) {
                    continue;
                }
 
                // 이동
                int nr = cur.r + drs[cur.d];
                int nc = cur.c + dcs[cur.d];
                // int nd = cur.d;
 
                // 약품이 있는 셀에 도착
                if (isEdge(nr, nc)) {
 
                    // 군집이 사라진다.
                    cnt[id] /= 2;
                    if (cnt[id] > 0) {
 
                        if (cur.d == 1) {
                            cur.d = 2;
                        } else if (cur.d == 2) {
                            cur.d = 1;
                        } else if (cur.d == 3) {
                            cur.d = 4;
                        } else {
                            cur.d = 3;
                        }
                    } else {
                        continue;
                    }
                }
 
                // 한셀에 두 군집이 모이는 경우
                if (map[0][nr][nc] == cur.m && map[1][nr][nc] > -1) {
                    int other = map[1][nr][nc];
 
                    if (cnt[id] > cnt[other]) {
                        cnt[id] += cnt[other];
                        cnt[other] = 0;
                        cur.r = nr;
                        cur.c = nc;
 
                        // 지워주는 부분을 고민해보자
 
                        cur.m++;
 
                        map[1][nr][nc] = id;
 
                    } else {
                        cnt[other] += cnt[id];
                        cnt[id] = 0;
                    }
                } else { // 그냥 이동
                    map[0][nr][nc] = cur.m; // 날짜
                    map[1][nr][nc] = id; // 군집 번호
                    cur.r = nr;
                    cur.c = nc;
                    cur.m++;
 
                }
            }
        }
    }
 
    private static boolean isEdge(int r, int c) {
        return r == 0 || r == N - 1 || c == 0 || c == N - 1;
    }
 
}
