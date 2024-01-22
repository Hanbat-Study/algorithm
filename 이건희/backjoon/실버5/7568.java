import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(nums[0]);
            arr[i][1] = Integer.parseInt(nums[1]);
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    cnt++;
            }
            System.out.print(cnt + " ");
        }
    }
}
