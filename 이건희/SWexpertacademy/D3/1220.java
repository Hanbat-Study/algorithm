import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int result = 0;
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            for (int i = 0; i < N; i++) {
                boolean check = false;
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 1) {
                        check = true;
                    } else if (check && arr[j][i] == 2) {
                        result++;
                        check = false;
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
