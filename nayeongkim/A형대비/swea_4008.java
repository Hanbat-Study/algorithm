import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4008 {
    private  static int res, max, min, n, size;
    private static int[] op = new int[4];
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            size = 2 * n - 1;
            nums = new int[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i+=2) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            perm(1);
            res = max - min;
            System.out.printf("#%d %d\n",t, res);
        }
    }

    private static void perm(int cnt) {
        if (cnt == size) {
            int total = cal(nums);
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;

        }
        for (int i =0; i <4; i++) {
            if (op[i] > 0) {
            nums[cnt] = i;
            op[i]--;
            perm(cnt + 2);
            op[i]++;
            }
        }
    }

    private static int cal(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < size - 1; i += 2) {
            if (nums[i] == 0) {
                sum += nums[i +1];
            }
            else if (nums[i] == 1) {
                sum -= nums[i +1];
            }
            else if (nums[i] == 2) {
                sum *= nums[i +1];
            }else  {
                sum /= nums[i +1];
            }
        }
        return sum;
    }
}
