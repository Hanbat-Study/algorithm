import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 0; i < N; i++) {
                String[] token = br.readLine().split("");
                int range = Math.abs( N / 2 - i );
                for(int j = 0; j<N; j++){

                    if (range<= j && j < N -range)  {
                        sum += Integer.parseInt(token[j]);
                    }

                }
            }
            System.out.printf("#%d %d\n",test_case,sum);
        }
    }
}