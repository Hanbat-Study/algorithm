import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int[][] arr90 = new int[N][N];
            int[][] arr180 = new int[N][N];
            int[][] arr270 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();

                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr90[i][j] = arr[N-1-j][i];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr180[i][j] = arr90[N-1-j][i];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr270[i][j] = arr180[N-1-j][i];
                }
            }
            for (int i = 0; i < N; i++) {
                for(int j=0;j<N;j++){
                    System.out.print(arr90[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(arr180[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(arr270[i][j]);
                }
                System.out.println();
            }
        }
    }
}