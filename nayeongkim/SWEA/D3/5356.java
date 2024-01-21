import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[][] strings = new String[5][];
            int max_c = 0;
            int col = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                strings[i] = br.readLine().split("");
                col = strings[i].length;
                max_c = Math.max(col, max_c);

            }
            for(int j = 0; j<max_c; j++){
                for (int i = 0; i < 5; i++) {
                    if(j < strings[i].length){
                        sb.append(strings[i][j]);
                    }

                }
            }

            System.out.printf("#%d %s\n",tc,sb);
        }

    }
}