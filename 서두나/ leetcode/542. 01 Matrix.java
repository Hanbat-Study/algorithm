// 0에 가까운 곳 

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;
        int[][] output = new int[r][c];

        if (mat[0][0] == 1) {
            output[0][0] = 100000;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    output[i][j] = Math.min(output[i - 1][j], output[i][j - 1]) + 1;
                } else if (i - 1 >= 0) {
                    output[i][j] = output[i - 1][j] + 1;
                } else if (j - 1 >= 0) {
                    output[i][j] = output[i][j - 1] + 1;
                }
            }
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }

                if (i + 1 < r && j + 1 < c) {
                    output[i][j] = Math.min(output[i][j], Math.min(output[i + 1][j], output[i][j + 1]) + 1);
                } else if (i + 1 < r) {
                    output[i][j] = Math.min(output[i][j], output[i + 1][j] + 1);
                } else if (j + 1 < c) {
                    output[i][j] = Math.min(output[i][j], output[i][j + 1] + 1);
                }
            }
        }

        return output;
    }
}
