import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int[][] flies = new int[N][N];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    flies[i][j] = sc.nextInt();
             
            int max = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int sum1 = flies[i][j];
                    int sum2 = flies[i][j];
                    for(int x = 1; x < M; x++) {
                        if(j - x >= 0)
                            sum1 += flies[i][j - x];
                        if(j + x < N)
                            sum1 += flies[i][j + x];
                        if(i - x >= 0)
                            sum1 += flies[i - x][j];
                        if(i + x < N)
                            sum1 += flies[i + x][j];
                         
                        if(i - x >= 0 && j - x >= 0)
                            sum2 += flies[i - x][j - x];
                        if(i + x < N && j + x < N)
                            sum2 += flies[i + x][j + x];
                        if(i - x >= 0 && j + x < N)
                            sum2 += flies[i - x][j + x];
                        if(i + x < N && j - x >= 0)
                            sum2 += flies[i + x][j - x];
                    }
                     
                    int tmp = sum1 > sum2 ? sum1 : sum2;
                    if(max < tmp)
                        max = tmp;
                }
            }
             
            System.out.println("#" + test_case + " " + max);
        }
    }
}
