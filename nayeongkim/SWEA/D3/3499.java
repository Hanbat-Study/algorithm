import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int idx = N / 2;
            String[] strings = br.readLine().split(" ");
            String[] result = new String[N];
            if (N % 2 == 0) {

                for (int i = 0; i < idx; i++) {
                    result[i * 2] = strings[i];
                    result[i * 2 + 1] = strings[idx + i];
                }
            } else {
                for (int i = 0; i < idx; i++) {
                    result[i * 2] = strings[i];
                    result[i * 2 + 1] = strings[idx + i + 1];
                }
                result[N - 1] = strings[idx];
            }

            System.out.printf("#%d", test_case);
            for(String s : result){
                System.out.printf("%s ", s);
            }
            System.out.println();

        }
    }
}
