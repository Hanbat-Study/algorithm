class Solution {
    public int solution(String[][] board, int h, int w) {
        int result = 0;
        int N = board[0].length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        String now = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int dx = w + dw[i];
            int dy = h + dh[i];
            
            if (0 <= dx && dx < N && 0 <= dy && dy < N && board[dy][dx].equals(now)) {
                result++;
            }
        }
        
        return result;
    }
}
