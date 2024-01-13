import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++) {            
            int[][] arr = new int[9][9];
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
             
            int rowIdx = 0;
            int colIdx = 0;
            boolean flag = false;
            for(int i = 0; i < 9; i++){
                int[] row = new int[9];
                int[] col = new int[9];
                int[] box = new int[9];
                 
                for(int j = 0; j < 9; j++) {
                    if(row[arr[i][j] - 1] != 0 || col[arr[j][i] - 1] != 0 || box[arr[rowIdx][colIdx] - 1] != 0) {
                        flag = true;
                        break;
                    }
                     
                    row[arr[i][j] - 1]++;
                    col[arr[j][i] - 1]++;
                    box[arr[rowIdx][colIdx] - 1]++;
                    if((j + 1) % 3 == 0) {
                        colIdx -= 2;
                        rowIdx++;
                    }
                    else
                        colIdx++;
                }
                if(flag) {
                    System.out.println("#" + test_case + " " + 0);
                    break;
                }
                if((i + 1) % 3 == 0) {
                    rowIdx -= 9;
                    colIdx += 3;
                }
            }
             
            if(!flag)
                System.out.println("#" + test_case + " " + 1);
        }
         
        sc.close();
    }
}
