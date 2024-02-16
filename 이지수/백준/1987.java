import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int result;
	static char[][] board;
	static boolean[] alphabets = new boolean[26];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        
        int R = Integer.parseInt(tmp[0]);
        int C = Integer.parseInt(tmp[1]);
        
        board = new char[R + 2][C + 3];
        for(int i = 1; i <= R; i++) {
        	tmp = br.readLine().split("");
        	for(int j = 1; j <= C; j++)
        		board[i][j] = tmp[j - 1].charAt(0);
        }

        BFS(1, 1, 0);
        System.out.println(result + 1);
    }
    
    private static void BFS(int r, int c, int cnt) {   	
    	char tmp = board[r][c];
    	alphabets[board[r][c] - 'A'] = true;
		board[r][c] = '\0';

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for(int i = 0; i < 4; i++) {
			int idxr = r + dx[i];
			int idxc = c + dy[i];
			
			if(board[idxr][idxc] == '\0' || alphabets[board[idxr][idxc] - 'A']) continue;
			
			BFS(idxr, idxc, cnt + 1);
		}
		
		result = Math.max(result, cnt);
		board[r][c] = tmp;
		alphabets[board[r][c] - 'A'] = false;
    }
}
