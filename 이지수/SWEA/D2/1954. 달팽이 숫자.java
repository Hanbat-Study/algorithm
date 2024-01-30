import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int arr[][] = new int[N][N];
            
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int dirIdx = 0;
            
            int cnt = 1;
            
            int r = 0;
            int c = 0;
            
            while(cnt <= N * N){
            	if(r + dx[dirIdx] >= N || r + dx[dirIdx] < 0 || c + dy[dirIdx] >= N || c + dy[dirIdx] < 0 || arr[r + dx[dirIdx]][c + dy[dirIdx]] != 0)
            		dirIdx = (dirIdx + 1) % 4;
                arr[r][c] = cnt;
                r += dx[dirIdx];
                c += dy[dirIdx];
                cnt++;
            }
            
            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++) {
             	for(int j = 0; j < N; j++) {
                 	System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
		}
	}
}
