import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_17135 {
    static int N, M, D, answer = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(new int[3], 0, 0);
        System.out.println(answer);
    }

    // 궁수의 위치를 조합으로 선택
    static void combination(int[] archers, int start, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, simulate(archers));
            return;
        }
        for (int i = start; i < M; i++) {
            archers[depth] = i;
            combination(archers, i + 1, depth + 1);
        }
    }

    // 시뮬레이션 실행
    static int simulate(int[] archers) {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, M);
        }

        int count = 0;
        for (int turn = 0; turn < N; turn++) {
            count += attackAndCount(copyMap, archers);
            moveEnemies(copyMap);
        }
        return count;
    }

    // 궁수 공격 및 적 카운트
    static int attackAndCount(int[][] map, int[] archers) {
        ArrayList<int[]> targets = new ArrayList<>();
        for (int archer : archers) {
            int closest = D + 1;
            int targetX = -1, targetY = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        int distance = Math.abs(N - i) + Math.abs(archer - j);
                        if (distance <= D) {
                            if (distance < closest || (distance == closest && j < targetY)) {
                                closest = distance;
                                targetX = i;
                                targetY = j;
                            }
                        }
                    }
                }
            }
            if (targetX != -1) {
                targets.add(new int[]{targetX, targetY});
            }
        }

        // 중복 제거 후 적 제거
        int killed = 0;
        for (int[] target : targets) {
            if (map[target[0]][target[1]] == 1) {
                map[target[0]][target[1]] = 0;
                killed++;
            }
        }
        return killed;
    }

    // 적 이동
    static void moveEnemies(int[][] map) {
        for (int i = N - 1; i > 0; i--) {
            System.arraycopy(map[i - 1], 0, map[i], 0, M);
        }
        for (int j = 0; j < M; j++) {
            map[0][j] = 0;
        }
    }
}
