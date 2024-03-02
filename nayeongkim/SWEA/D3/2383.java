import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.midi.Soundbank;

 class Solution_2383 {

    static int n, res, map[][], peopleCnt, a, b;
    static boolean[] isSelected;
    static ArrayList<ArrayList<Integer>> groupA, groupB;
    static ArrayList<int[]> people;
    static ArrayList<int[]> stairs;
    //static ArrayList<ArrayList<Stairs>> stair;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            groupA = new ArrayList<>();
            groupB = new ArrayList<>();
            for (int i = 0; i <=20; i++) {
                groupA.add(new ArrayList<>());
                groupB.add(new ArrayList<>());
            }
            res = Integer.MAX_VALUE;
            people = new ArrayList<>();
            stairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) people.add(new int[] {i, j});
                    else if (2 <= map[i][j] && map[i][j] <= 10) stairs.add(new int[] { i, j, map[i][j]});
                }
            }
            peopleCnt = people.size();
            isSelected = new boolean[peopleCnt];
            simulate(0, new int[peopleCnt]);
            System.out.println("#"+ tc + " "+ res);
        }
    }
    private static void simulate(int index, int[] selectedStairs) {
        if (index == peopleCnt) {
            res = Math.min(res, cal(selectedStairs));
            return;
        }

        for (int i = 0; i < 2; i++) {
            selectedStairs[index] = i;
            simulate(index + 1, selectedStairs);
        }
    }
    private static int cal(int[] selectedStairs) {
        int time = 0;
        Queue<Integer>[] waiting = new LinkedList[2];
        Queue<Integer>[] descending = new LinkedList[2];

        for (int i = 0; i < 2; i++) {
            waiting[i] = new LinkedList<>();
            descending[i] = new LinkedList<>();
        }

        for (int i = 0; i < peopleCnt; i++) {
            int[] person = people.get(i);
            int[] stair = stairs.get(selectedStairs[i]);
            int dist = Math.abs(person[0] - stair[0]) + Math.abs(person[1] - stair[1]);
            waiting[selectedStairs[i]].add(dist + 1);
        }


        while (true) {
            for (int i = 0; i < 2; i++) {
                while (!descending[i].isEmpty() && descending[i].peek() <= time) {
                    descending[i].poll(); // 계단을 다 내려간 사람 제거
                }
                while (descending[i].size() < 3 && !waiting[i].isEmpty() && waiting[i].peek() <= time) {
                    int waitTime = waiting[i].poll();
                    descending[i].add(time + stairs.get(i)[2]); // 계단을 내려가는데 걸리는 시간 추가
                }
            }
            if (areAllPeopleDescended(waiting, descending)) break;
            time++;
        }
        return time;
    }

    private static boolean areAllPeopleDescended(Queue<Integer>[] waiting, Queue<Integer>[] descending) {
        for (int i = 0; i < 2; i++) {
            if (!waiting[i].isEmpty() || !descending[i].isEmpty()) return false;
        }
        return true;
    }

}
