
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {

    static int[] output, nums;
    static int K;
    static StringBuilder sb;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0)
                break;
            nums = new int[K];
            output = new int[6];
            isSelected = new boolean[K];
            sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            recur(0, 0);

            System.out.println(sb);

        }
    }

    private static void recur(int cnt, int start) {
        // TODO Auto-generated method stub
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < K; i++) {
            if(isSelected[i]) continue;
            output[cnt] = nums[i];
            isSelected[i] = true;
            recur(cnt+1, i+1);
            isSelected[i] = false;
        }
    }
}