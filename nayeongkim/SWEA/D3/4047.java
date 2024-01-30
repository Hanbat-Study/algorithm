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
            int[] cnts = {13, 13, 13, 13};
            int[][] arr  = new int[4][14];
            boolean duplication = false;
            String[] strings = br.readLine().split("");
            for (int i = 0; i < strings.length ; i += 3) {
                int num = Integer.parseInt(strings[i + 1] + strings[i + 2]);
                if (strings[i].equals("S")) {
                    arr[0][num]++;
                    if(arr[0][num]!=1){
                        duplication =true;
                        break;
                    }
                    cnts[0]--;
                } else if (strings[i].equals("D")) {
                    arr[1][num]++;
                    if(arr[1][num]!=1){
                        duplication =true;
                        break;
                    }
                    cnts[1]--;
                } else if (strings[i].equals("H")) {
                    arr[2][num]++;
                    if(arr[2][num]!=1){
                        duplication =true;
                        break;
                    }
                    cnts[2]--;
                } else if (strings[i].equals("C")) {
                    arr[3][num]++;
                    if(arr[3][num]!=1){
                        duplication =true;
                        break;
                    }
                    cnts[3]--;
                }
            }
            if(duplication){
                System.out.printf("#%d ERROR\n",test_case);
            }else{
                System.out.printf("#%d %d %d %d %d\n", test_case, cnts[0], cnts[1], cnts[2], cnts[3]);
            }

        }
    }
}