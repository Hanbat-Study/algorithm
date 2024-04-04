import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int tc = pint(br.readLine());
        for (int testcase = 1; testcase <= tc; testcase++) {
 
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = pint(st.nextToken());
            int x = pint(st.nextToken());
            int[][]map = new int[n][n];
 
            for (int i = 0; i < n; i++) {
                st=new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < n; j++) {
                    map[i][j]=pint(st.nextToken());
                }
            }
             
            int possibleCnt=0;
             
            for (int i = 0; i < n; i++) {
                boolean isP = true;
                 
                for (int j = 1; j < n; j++) {
                    if(Math.abs(map[i][j] - map[i][j-1]) >=2)isP=false;
                }if(!isP)continue;
                 
                int prev=map[i][0];
                int cnt=1;
                for (int j = 1; j < n; j++) {
                    if(prev == map[i][j])cnt++;
                    else if(prev< map[i][j]) {
                        if(cnt>=x) {
                            //ok
                        }
                        else {
                            isP=false;
                        }
                        prev=map[i][j];
                        cnt=1;
                    }
                    else {
                        prev = map[i][j];
                        cnt=1;
                        for (int j2 = 1; j2 < x; j2++) {
                            if(j+j2 >= n)break;
                            if(prev==map[i][j+j2])cnt++;
                        }
                        if(cnt!=x)isP=false;
                        j = j+x-1;
                        cnt=0;
                    }
                }
                if(isP)possibleCnt++;
            }
             
            for (int i = 0; i < n; i++) {
                boolean isP = true;
                 
                for (int j = 1; j < n; j++) {
                    if(Math.abs(map[j][i] - map[j-1][i]) >=2)isP=false;
                }if(!isP)continue;
                 
                int prev=map[0][i];
                int cnt=1;
                for (int j = 1; j < n; j++) {
                    if(prev == map[j][i])cnt++;
                    else if(prev< map[j][i]) {
                        if(cnt>=x) {
                        }
                        else {
                            isP=false;
                        }
                        prev=map[j][i];
                        cnt=1;
                    }
                    else {
                        prev = map[j][i];
                        cnt=1;
                        for (int j2 = 1; j2 < x; j2++) {
                            if(j+j2 >= n)break;
                            if(prev==map[j+j2][i])cnt++;
                        }
                        if(cnt!=x)isP=false;
                        j = j+x-1;
                        cnt=0;
                    }
                     
                }
                if(isP)possibleCnt++;
            }
             
            sb.append("#").append(testcase).append(" ").append(possibleCnt).append("\n");
        }
        System.out.println(sb);
         
    }
    static int pint(String s) {
        return Integer.parseInt(s);
    }
}
