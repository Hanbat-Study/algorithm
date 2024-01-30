import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            String[][] map = new String[N][N];
            
            for(int i = 0; i < N; i++)
             	map[i] = br.readLine().split(" ");  
            
            int max = -1;
            int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
            int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
            for(int i = 0; i < N; i++) {
             	for(int j = 0; j < N; j++) {
                    int depth = 0;
                    for(int k = 0; k < 8; k++) {
                        int r = i + dx[k];
                        int c = j + dy[k];
                    	if(r >= N || r < 0 || c >= N || c < 0)
                            continue;
                        if(map[r][c].equals("W"))
                            depth++;
                    }
                    if(depth == 0 && map[i][j].equals("W"))
                        depth++;
                    if(depth > max)
                        max = depth;
                }
            }
            System.out.println("#" + test_case + " " + max);
		}
	}
}
