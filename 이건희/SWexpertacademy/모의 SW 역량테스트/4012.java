import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    static int N, result;
    static int[] numbers;
    static int[][] arr;
    static boolean[] nums;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            arr = new int[N][N];
            numbers = new int[N];
            nums = new boolean[N];
 
            for (int i = 0; i < N; i++) {
                numbers[i] = i + 1;
            }
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
 
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            combi(0, 0);
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    private static void combi(int idx, int cnt) {
        if (cnt == N / 2) {
            result = Math.min(result, cal());
            return;
        }
 
        for (int i = idx; i < N; i++) {
            nums[i] = true;
            combi(i + 1, cnt + 1);
            nums[i] = false;
        }
    }
 
    private static int cal() {
        int food1 = 0;
        int food2 = 0;
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
 
                if (nums[i] && nums[j]) {
                    food1 += arr[i][j];
                } else if (!nums[i] && !nums[j]) {
                    food2 += arr[i][j];
                }
            }
        }
        return Math.abs(food1 - food2);
    }
}
